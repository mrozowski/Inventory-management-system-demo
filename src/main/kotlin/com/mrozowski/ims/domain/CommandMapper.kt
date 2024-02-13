package com.mrozowski.ims.domain

import com.mrozowski.ims.domain.model.InventoryEventUpdatedCommand
import com.mrozowski.ims.domain.model.Item
import org.springframework.stereotype.Component

@Component
class CommandMapper {

    fun toInventoryEventUpdatedCommand(
        item: Item,
        eventType: InventoryEventUpdatedCommand.EventType
    ): InventoryEventUpdatedCommand {
        return InventoryEventUpdatedCommand(
            internalId = item.internalId,
            itemName = item.name,
            currentQuantity = item.quantity,
            eventType = eventType
        )
    }
}