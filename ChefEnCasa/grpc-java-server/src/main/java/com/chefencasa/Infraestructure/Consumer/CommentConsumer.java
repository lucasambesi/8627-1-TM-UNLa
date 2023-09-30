package com.chefencasa.Infraestructure.Consumer;

import com.chefencasa.Infraestructure.Consumer.Json.CommentJson;
import com.chefencasa.Model.Comment;
import com.chefencasa.service.CommentService;
import com.chefencasa.service.RecipeService;
import com.chefencasa.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class CommentConsumer {
    private final Consumer<String, String> consumer;

    public CommentService commentService = CommentService.getInstance();

    public UserService userService = UserService.getInstance();

    public RecipeService recipeService = RecipeService.getInstance();

    public CommentConsumer(Properties properties) {
        this.consumer = new KafkaConsumer<>(properties);
    }

    public void consumeMessages(String topic) {
        TopicPartition topicPartition = new TopicPartition(topic, 0);
        consumer.assign(Collections.singletonList(topicPartition));

        ObjectMapper objectMapper = new ObjectMapper();

        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
        for (ConsumerRecord<String, String> record : records) {
            try {
                CommentJson commentJson = objectMapper.readValue(record.value(), CommentJson.class);
                System.out.println("Comment: " + commentJson.getValue());

                commentService.saveComment(mapToEntity(commentJson));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void close() {
        consumer.close();
    }

    public Comment mapToEntity(CommentJson commentJson) throws Exception {
        Comment comment = new Comment();
        comment.setRecipe(recipeService.getById(commentJson.getIdRecipe()));
        comment.setUser(userService.getById(commentJson.getIdUser()));
        comment.setValue(commentJson.getValue());
        return comment;
    }
}