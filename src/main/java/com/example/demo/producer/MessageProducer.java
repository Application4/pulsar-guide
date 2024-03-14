package com.example.demo.producer;

import com.example.demo.Book;
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
    @Value("${spring.pulsar.producer.topic-name1}")
    private String topicName1;
    @Value("${spring.pulsar.producer.topic-name2}")
    private String topicName2;

    public void publish(String message) throws PulsarClientException {
        pulsarTemplate.send(topicName1, message);
        log.info("message published {}", message);
    }


    public void publish(Book book) throws PulsarClientException {
        pulsarTemplate.send(topicName2, book);
        log.info("message published book id {} & name {}", book.getId() , book.getName());
    }
}
