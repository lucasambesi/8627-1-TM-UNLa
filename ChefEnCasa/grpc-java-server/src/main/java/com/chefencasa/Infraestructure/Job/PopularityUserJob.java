package com.chefencasa.Infraestructure.Job;

import com.chefencasa.Infraestructure.Consumer.PopularityRecipeConsumer;
import com.chefencasa.Infraestructure.Consumer.PopularityUserConsumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;
import java.util.Properties;

public class PopularityUserJob implements Job {

    private PopularityUserConsumer kafkaConsumer;

    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("PopularityUserJob ejecuted - " + new Date());

        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:29092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "popularity-user-consumer-group");

        this.kafkaConsumer = new PopularityUserConsumer(properties);

        System.out.println("Starting message consumption...");

        kafkaConsumer.consumeMessages("chefencasa-PopularidadUsuario");
        kafkaConsumer.close();

        System.out.println("Message consumption completed.");
    }
}
