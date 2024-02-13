package com.mrozowski.ims.domain

import com.mrozowski.ims.domain.model.InventoryEventCommand
import com.mrozowski.ims.domain.model.InventoryEventUpdatedCommand
import com.mrozowski.ims.domain.model.Item

class Fixtures {

  static def INTERNAL_ID = "123456"
  static def NAME = "Test Item"
  static def DESCRIPTION = "Sample description"
  static def AMOUNT = 1
  static def QUANTITY = 50
  static def PRICE = 100

  static def OPERATION_ADDED = InventoryEventCommand.Operation.ADDED
  static def OPERATION_SOLD = InventoryEventCommand.Operation.SOLD
  static def COMMAND_EVENT_TYPE_UPDATED = InventoryEventUpdatedCommand.EventType.UPDATED


  static def createSampleEventSoldCommand() {
    return new InventoryEventCommand(
        INTERNAL_ID,
        NAME,
        AMOUNT,
        OPERATION_SOLD
    )
  }

  static def createSampleItem() {
    return new Item(
        INTERNAL_ID,
        NAME,
        DESCRIPTION,
        QUANTITY,
        PRICE
    )
  }

  static def createSampleUpdatedEventCommand() {
    return new InventoryEventUpdatedCommand(
        INTERNAL_ID,
        NAME,
        QUANTITY - AMOUNT,
        COMMAND_EVENT_TYPE_UPDATED
    )
  }
}
