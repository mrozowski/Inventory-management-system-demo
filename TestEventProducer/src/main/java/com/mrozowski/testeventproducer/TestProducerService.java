package com.mrozowski.testeventproducer;

import com.mrozowski.testeventproducer.InventoryItemEventMessage.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class TestProducerService {

  private final TestMessageGenerator testMessageGenerator;
  private final TestPublisher testPublisher;

  void generateAndPublishMessage(int id, int amount, Operation operation) {
    testPublisher.sendMessage(testMessageGenerator.generateItemMessage(id, amount, operation));
  }
}

