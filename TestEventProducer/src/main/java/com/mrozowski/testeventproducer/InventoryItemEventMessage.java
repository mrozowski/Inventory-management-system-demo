package com.mrozowski.testeventproducer;

import lombok.Builder;

import java.io.Serializable;

@Builder
public record InventoryItemEventMessage(
    String internalItemId,
    String itemName,
    int amount,
    Operation operation) implements Serializable {

  public enum Operation {
    ADDED,
    SOLD
  }
}
