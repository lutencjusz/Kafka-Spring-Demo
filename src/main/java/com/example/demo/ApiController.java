package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping(value="/message/{key}/{value}")
    @ResponseBody
    public String produceMessageToKafkaTopic(@PathVariable String key, @PathVariable String value) {
        kafkaTemplate.send("producer-example", key, value);
        return "Komunikat wysłany do Kafki z powodzeniem";
    }

}
