package com.chefencasa.Infraestructure.Consumer;

import com.chefencasa.Infraestructure.Consumer.Json.PopularityRecipeJson;
import com.chefencasa.Model.Recipe;
import com.chefencasa.Repository.RecipeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.*;

public class PopularityRecipeConsumer {
    private final Consumer<String, String> consumer;

    public RecipeRepository recipeRepository = RecipeRepository.getInstance();

    public PopularityRecipeConsumer(Properties properties) {
        this.consumer = new KafkaConsumer<>(properties);
    }

    public void consumeMessages(String topic) {
        TopicPartition topicPartition = new TopicPartition(topic, 0);
        consumer.assign(Collections.singletonList(topicPartition));

        ObjectMapper objectMapper = new ObjectMapper();

        List<Recipe> recipes = new ArrayList<>();
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
        for (ConsumerRecord<String, String> record : records) {
            try {
                PopularityRecipeJson popularityRecipeJson = objectMapper.readValue(record.value(), PopularityRecipeJson.class);
                System.out.println("Popularity recipe: " + popularityRecipeJson.getIdRecipe() + popularityRecipeJson.getScore());

                Optional<Recipe> existingRecipe = recipes.stream()
                        .filter(recipe -> recipe.getIdRecipe() == popularityRecipeJson.getIdRecipe())
                        .findFirst();

                Recipe recipe;
                if (existingRecipe.isPresent()) {
                    recipe = existingRecipe.get();
                } else {
                    recipe = recipeRepository.getById(popularityRecipeJson.getIdRecipe());
                    if (recipe != null) {
                        recipes.add(recipe);
                    }
                }

                int score = Integer.parseInt(popularityRecipeJson.getScore());
                score = Math.max(-5, Math.min(5, score));

                recipe.setPopularity(recipe.getPopularity() + score);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            for (Recipe recipe : recipes) {
                recipeRepository.saveOrUpdateRecipe(recipe);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        consumer.close();
    }

}
