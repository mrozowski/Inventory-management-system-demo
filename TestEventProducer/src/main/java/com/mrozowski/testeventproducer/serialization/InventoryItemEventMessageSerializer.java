package com.mrozowski.testeventproducer.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrozowski.testeventproducer.InventoryItemEventMessage;
import org.apache.kafka.common.serialization.Serializer;

import java.io.IOException;

public class InventoryItemEventMessageSerializer implements Serializer<InventoryItemEventMessage> {
  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public byte[] serialize(String topic, InventoryItemEventMessage data) {
    try {
      return objectMapper.writeValueAsBytes(data);
    } catch (IOException e) {
      throw new RuntimeException("Error serializing InventoryItemEventMessage", e);
    }
  }
}
