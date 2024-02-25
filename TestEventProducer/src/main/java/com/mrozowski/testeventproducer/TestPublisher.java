package com.mrozowski.testeventproducer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

@Slf4j
@Component
@RequiredArgsConstructor
class TestPublisher {

  private final KafkaTemplate<String, InventoryItemEventMessage> kafkaTemplate;

  void sendMessage(InventoryItemEventMessage message) {
    log.info("Publishing message");
    kafkaTemplate.send("inventory-topic", message);
    log.info("Message Published: [{}]", message);
  }
}
