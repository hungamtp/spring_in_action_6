package com.example.kafka.kafka;

import com.example.kafka.constrant.ApplicationConstant;
import com.example.kafka.model.Student;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

public class SpringKafkaConfig {
    @Bean
    public ConsumerFactory<String, String> consumingEventStringMessage() {
        Map<String, Object> configMap = new HashMap<>();
        configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, ApplicationConstant.KAFKA_LOCAL_SERVER_CONFIG);
        configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configMap.put(ConsumerConfig.GROUP_ID_CONFIG, ApplicationConstant.GROUP_ID_STRING);
        return new DefaultKafkaConsumerFactory<>(configMap);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> listenerEventSendStringMessage() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
        factory.setConsumerFactory(consumingEventStringMessage());
        return factory;
    }
}
