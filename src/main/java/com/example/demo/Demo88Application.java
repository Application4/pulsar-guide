package com.example.demo;

import com.example.demo.producer.MessageProducer;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.stream.IntStream;

@SpringBootApplication
@RestController
@RequestMapping("/producer")
public class Demo88Application {
    @Autowired
    private MessageProducer producer;


	@GetMapping("/plain")
    public String publishTextEvent() throws PulsarClientException {
        producer.publish(UUID.randomUUID().toString());
        return "Success !";
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo88Application.class, args);
    }

}
