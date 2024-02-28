package com.example.demos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    @Autowired
    private KafkaProducerService kafkaProducerService;


    @PostMapping("/send")
    public String send(@RequestParam("message") String message) {
        kafkaProducerService.sendMessage(message);
        return "success";
    }
}
