package com.chefencasa.Infraestructure.Producer;

import com.chefencasa.Infraestructure.Producer.Json.CreateRecipeJson;
import com.chefencasa.Model.Recipe;
import com.chefencasa.Model.RecipeImage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.var;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.KafkaException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Objects;
import java.util.Properties;

public class CreateRecipeProducer {
    private static CreateRecipeProducer producer;
    private KafkaProducer<String, String> kafkaProducer;

    private CreateRecipeProducer() {
        try {
            var conf = new Properties();
            conf.load(new FileReader("src/main/resources/producer.properties"));

            this.kafkaProducer = new KafkaProducer<String, String>(conf);

        } catch (IOException ioe) {
            log.error(ioe.getMessage());
        }
    }
    public void send(String key, Recipe recipe) {
        try {

            CreateRecipeJson msj = new CreateRecipeJson();

            msj.setRecipeId(recipe.getIdRecipe());
            msj.setTitle(recipe.getTitle());
            msj.setUsername(recipe.getUser().getUsername());

            ArrayList<RecipeImage> images = new ArrayList<>(recipe.getImages());

            if (!images.isEmpty()) {
                RecipeImage recipeImage = images.get(0);
                String parsed = Base64.getEncoder().encodeToString(recipeImage.getFile());

                //msj.setFile(parsed);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonMessage = objectMapper.writeValueAsString(msj);

            var record = new ProducerRecord<String, String>(TOPIC, PARTITION, key, jsonMessage.toString());

            this.kafkaProducer.send(record);
        } catch (KafkaException e) {
            log.error(e.getMessage());
            this.close();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        this.kafkaProducer.close();
    }

    public static CreateRecipeProducer getInstance() {
        return (Objects.nonNull(producer)) ? producer : new CreateRecipeProducer();
    }

    private static final String TOPIC = "Novedades";
    private static final Integer PARTITION = 0;
    private static final Logger log = LogManager.getLogger(Producer.class);
}
