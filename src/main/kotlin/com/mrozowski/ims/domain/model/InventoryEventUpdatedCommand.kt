package com.mrozowski.ims.domain.model

class InventoryEventUpdatedCommand(
    val internalId: String,
    val itemName: String,
    val currentQuantity: Int,
    val eventType: EventType
) {

    enum class EventType {
        UPDATED,
        LOW_INVENTORY,
        EMPTY_INVENTORY
    }
}