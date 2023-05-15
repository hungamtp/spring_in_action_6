package com.example.kafka.controller;

import com.example.kafka.constrant.ApplicationConstant;
import com.example.kafka.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produce")
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @GetMapping("/{message}")
    public String sendMessage(@PathVariable String message) {

        try {
            kafkaTemplate.send(ApplicationConstant.TOPIC_NAME, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Message sent succuessfully";
    }
}
