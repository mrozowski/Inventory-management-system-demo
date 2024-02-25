package com.mrozowski.testeventproducer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("v1/produce")
@RequiredArgsConstructor
class TestRestController {

  private final TestProducerService testProducerService;

  @PostMapping("sold")
  ResponseEntity<Void> itemSold(@RequestParam("id") int id, @RequestParam("amount") int amount) {
    log.info("Receive request to produce sold item message");
    testProducerService.generateAndPublishMessage(id, amount, InventoryItemEventMessage.Operation.SOLD);
    return ResponseEntity.ok().build();
  }

  @PostMapping("added")
  ResponseEntity<Void> itemAdded(@RequestParam("id") int id, @RequestParam("amount") int amount) {
    log.info("Receive request to produce added item message");
    testProducerService.generateAndPublishMessage(id, amount, InventoryItemEventMessage.Operation.ADDED);
    return ResponseEntity.ok().build();
  }
}
