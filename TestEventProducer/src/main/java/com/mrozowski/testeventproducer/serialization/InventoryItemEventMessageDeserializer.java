package com.mrozowski.testeventproducer.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrozowski.testeventproducer.InventoryItemEventMessage;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class InventoryItemEventMessageDeserializer implements Deserializer<InventoryItemEventMessage> {
  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public InventoryItemEventMessage deserialize(String topic, byte[] data) {
    try {
      return objectMapper.readValue(data, InventoryItemEventMessage.class);
    } catch (IOException e) {
      throw new RuntimeException("Error deserializing InventoryItemEventMessage", e);
    }
  }
}
