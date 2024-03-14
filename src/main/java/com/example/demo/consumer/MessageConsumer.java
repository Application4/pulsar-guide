package com.example.demo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.SubscriptionType;
import org.springframework.pulsar.annotation.PulsarListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageConsumer {

    @PulsarListener(
            topics = "${spring.pulsar.producer.topic-name}",
            subscriptionName = "my-subscription",
            subscriptionType = SubscriptionType.Shared
    )
    public void consumeStringEvent(String message) {
        log.info("consume message {} ", message);
    }
}
