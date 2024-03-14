package com.example.demo.consumer;

import com.example.demo.Book;
import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.SubscriptionType;
import org.apache.pulsar.common.schema.SchemaType;
import org.springframework.pulsar.annotation.PulsarListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageConsumer {

    @PulsarListener(
            topics = "${spring.pulsar.producer.topic-name1}",
            subscriptionName = "my-subscription",
            subscriptionType = SubscriptionType.Shared
    )
    public void consumeStringEvent(String message) {
        log.info("consume message {} ", message);
    }


    @PulsarListener(
            subscriptionName = "my-subscription",
            topics = "${spring.pulsar.producer.topic-name2}",
            schemaType = SchemaType.JSON,
            subscriptionType = SubscriptionType.Shared
    )
    public void consumeRawEvent(Book book) {
        log.info("consume message {} ", book.getName());
    }
}
