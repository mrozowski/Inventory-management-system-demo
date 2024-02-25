package com.mrozowski.testeventproducer;

import org.springframework.stereotype.Component;

import java.util.List;

import static com.mrozowski.testeventproducer.InventoryItemEventMessage.Operation;
import static com.mrozowski.testeventproducer.InventoryItemEventMessage.builder;

@Component
class TestMessageGenerator {

  private final static String INTERNAL_ID_PREFIX = "SKU00";
  private final static List<String> NAMES = List.of("Notebook", "Pen", "Calculator", "Sticky Notes", "Highlighter");

  InventoryItemEventMessage generateItemMessage(int id, int amount, Operation operation) {
    return builder()
        .internalItemId(INTERNAL_ID_PREFIX + id)
        .itemName(NAMES.get(id-1))
        .amount(amount)
        .operation(operation)
        .build();
  }
}