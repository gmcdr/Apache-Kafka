package io.conductor.demos;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.Properties;

public class KafkaProducerDemo {
    private static final Logger log = LoggerFactory.getLogger(KafkaProducerDemo.class.getSimpleName());
    public static void main(String[] args) {

        //Create Producer Properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        //Create the producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        //create a producer record
        ProducerRecord<String, String> producerRecord =
                new ProducerRecord<>("demo_java", "Hello World");

        //send the data async operation
        producer.send(producerRecord);

        //flush data - sync
        producer.flush();

        // flush and close producer
        producer.close();


    }
}
