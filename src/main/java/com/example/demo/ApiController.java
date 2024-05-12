package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Kontroler REST API, który pozwala na wysłanie komunikatu do Kafki.
 * <p>
 * Aby uruchomić Kafkę, należy w terminalu wpisać:
 * cd C:\Kafka\kafka_2.13-3.7.0
 * .\bin\windows\zookeeper-server-start.bat "C:\Kafka\kafka_2.13-3.7.0\config\zookeeper.properties"
 * <p>
 * w drugim terminalu:
 * cd C:\Kafka\kafka_2.13-3.7.0
 * .\bin\windows\kafka-server-start.bat "C:\Kafka\kafka_2.13-3.7.0\config\server.properties"
 */
@Controller
public class ApiController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping(value = "/message/{key}/{value}")
    @ResponseBody
    public String produceMessageToKafkaTopic(@PathVariable String key, @PathVariable String value) {
        kafkaTemplate.send("producer-example", key, value);
        return "Komunikat wysłany do Kafki z powodzeniem";
    }

    @GetMapping(value = "/message-commit/{key}/{value}")
    @ResponseBody
    public String produceCommitMessageToKafkaTopic(@PathVariable String key, @PathVariable String value) {
        kafkaTemplate.send("producer-commit-example", key, value);
        return "Komunikat do 'producer-commit-example' wysłany do Kafki z powodzeniem";
    }

}
