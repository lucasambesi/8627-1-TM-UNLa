package com.chefencasa.Infraestructure.Job;

import com.chefencasa.Infraestructure.Consumer.CommentConsumer;
import com.chefencasa.Infraestructure.Consumer.PopularityRecipeConsumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;
import java.util.Properties;

public class PopularityRecipeJob implements Job {

    private PopularityRecipeConsumer kafkaConsumer;

    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("PopularityRecipeJob ejecuted - " + new Date());

        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:29092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "popularity-recipe-consumer-group");

        this.kafkaConsumer = new PopularityRecipeConsumer(properties);

        System.out.println("Starting message consumption...");

        kafkaConsumer.consumeMessages("PopularidadReceta");
        kafkaConsumer.close();

        System.out.println("Message consumption completed.");
    }
}