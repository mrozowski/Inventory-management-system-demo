package com.mrozowski.ims.adapter.outgoing.kafka

import com.mrozowski.ims.domain.model.InventoryEventUpdatedCommand
import org.springframework.stereotype.Component

@Component
class KafkaMessageMapper {

    fun createMessage(event: InventoryEventUpdatedCommand): InventoryUpdatedEventMessage {
        return InventoryUpdatedEventMessage(
            internalId = event.internalId,
            itemName = event.itemName,
            currentQuantity = event.currentQuantity,
            eventType = inventoryEventType(event.eventType)
        )
    }

    private fun inventoryEventType(eventType: InventoryEventUpdatedCommand.EventType) =
        when (eventType) {
            InventoryEventUpdatedCommand.EventType.EMPTY_INVENTORY -> InventoryUpdatedEventMessage.InventoryEventType.EMPTY_INVENTORY_ALERT
            InventoryEventUpdatedCommand.EventType.LOW_INVENTORY -> InventoryUpdatedEventMessage.InventoryEventType.LOW_INVENTORY_ALERT
            InventoryEventUpdatedCommand.EventType.UPDATED -> InventoryUpdatedEventMessage.InventoryEventType.NO_ALERT
        }
}