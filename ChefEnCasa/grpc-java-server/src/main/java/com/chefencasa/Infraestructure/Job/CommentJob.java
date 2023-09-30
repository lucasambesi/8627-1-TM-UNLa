package com.chefencasa.Infraestructure.Job;

import com.chefencasa.Infraestructure.Consumer.CommentConsumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;
import java.util.Properties;

public class CommentJob implements Job {

    private CommentConsumer kafkaConsumer;

    public CommentJob() {}

    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("CommentJob ejecuted - " + new Date());

        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:29092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "comment-consumer-group-3");

        this.kafkaConsumer = new CommentConsumer(properties);

        System.out.println("Starting message consumption...");

        kafkaConsumer.consumeMessages("send-comments");
        kafkaConsumer.close();

        System.out.println("Message consumption completed.");
    }
}
