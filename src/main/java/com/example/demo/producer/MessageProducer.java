package com.example.demo.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.pulsar.core.PulsarTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageProducer {

    @Autowired
    private PulsarTemplate<Object> pulsarTemplate;
    @Value("${spring.pulsar.producer.topic-name}")
    private String topicName;

    public void publish(String message) throws PulsarClientException {
        pulsarTemplate.send(topicName, message);
        log.info("message published {}", message);
    }
}
