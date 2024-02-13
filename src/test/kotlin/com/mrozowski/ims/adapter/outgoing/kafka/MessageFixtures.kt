package com.mrozowski.ims.adapter.outgoing.kafka

import com.mrozowski.ims.domain.model.InventoryEventUpdatedCommand

object MessageFixtures {
    private const val INTERNAL_ID = "123456"
    private const val NAME = "Test Item"
    private const val QUANTITY = 10
     val KAFKA_MESSAGE_EVENT_TYPE = InventoryUpdatedEventMessage.InventoryEventType.NO_ALERT
     val INTERNAL_EVENT_TYPE = InventoryEventUpdatedCommand.EventType.UPDATED

    fun createInventoryEventMessage(): InventoryUpdatedEventMessage {
        return InventoryUpdatedEventMessage(
            internalId = INTERNAL_ID,
            itemName = NAME,
            currentQuantity = QUANTITY,
            eventType = KAFKA_MESSAGE_EVENT_TYPE
        )
    }

    fun createInventoryEventUpdatedCommand(): InventoryEventUpdatedCommand {
        return InventoryEventUpdatedCommand(
            internalId = INTERNAL_ID,
            itemName = NAME,
            currentQuantity = QUANTITY,
            eventType = INTERNAL_EVENT_TYPE
        )
    }
}