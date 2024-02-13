package com.mrozowski.ims.domain.model

data class InventoryEventCommand(
    val internalItemId: String,
    val itemName: String,
    val amount: Int,
    val operation: Operation
) {


    enum class Operation {
        ADDED,
        SOLD
    }
}