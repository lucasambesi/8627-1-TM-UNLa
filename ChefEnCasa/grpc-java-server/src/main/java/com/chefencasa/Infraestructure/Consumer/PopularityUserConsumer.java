package com.chefencasa.Infraestructure.Consumer;

import com.chefencasa.Infraestructure.Consumer.Json.PopularityUserJson;
import com.chefencasa.Model.User;
import com.chefencasa.Repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.*;

public class PopularityUserConsumer {
    private final Consumer<String, String> consumer;

    public UserRepository userRepository = UserRepository.getInstance();

    public PopularityUserConsumer(Properties properties) {
        this.consumer = new KafkaConsumer<>(properties);
    }

    public void consumeMessages(String topic) {
        TopicPartition topicPartition = new TopicPartition(topic, 0);
        consumer.assign(Collections.singletonList(topicPartition));

        ObjectMapper objectMapper = new ObjectMapper();

        List<User> users = new ArrayList<>();
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
        for (ConsumerRecord<String, String> record : records) {
            try {
                PopularityUserJson popularityUserJson = objectMapper.readValue(record.value(), PopularityUserJson.class);
                System.out.println("Popularity user: " + popularityUserJson.getIdUser() + popularityUserJson.getScore());

                Optional<User> existingUser = users.stream()
                        .filter(user -> user.getIdUser() == popularityUserJson.getIdUser())
                        .findFirst();

                User user;
                if (existingUser.isPresent()) {
                    user = existingUser.get();
                } else {
                    user = userRepository.getById(popularityUserJson.getIdUser());
                    if (user != null) {
                        users.add(user);
                    }
                }

                int score = Integer.parseInt(popularityUserJson.getScore());
                score = Math.max(-5, Math.min(5, score));

                user.setPopularity(user.getPopularity() + score);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            for (User user : users) {
                userRepository.saveOrUpdate(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        consumer.close();
    }
}
