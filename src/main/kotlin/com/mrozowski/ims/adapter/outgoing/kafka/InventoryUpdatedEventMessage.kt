package com.mrozowski.ims.adapter.outgoing.kafka

data class InventoryUpdatedEventMessage(
    val internalId: String,
    val itemName: String,
    val currentQuantity: Int,
    val eventType: InventoryEventType
) {

    enum class InventoryEventType{
        LOW_INVENTORY_ALERT,
        EMPTY_INVENTORY_ALERT,
        NO_ALERT
    }
}
