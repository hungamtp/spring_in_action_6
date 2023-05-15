package com.example.kafka.controller;

import com.example.kafka.constrant.ApplicationConstant;
import com.example.kafka.model.Student;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

@Component
public class KafkaConsumer {

//    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(groupId = ApplicationConstant.GROUP_ID_STRING, topics = ApplicationConstant.TOPIC_NAME,
        containerFactory = "listenerEventSendStringMessage")
    public void receivedMessage(String message) {
        System.out.println("Message Received using Kafka listener " + message);
    }
}
