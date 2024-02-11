package com.mrozowski.ims.domain.model

import com.mrozowski.ims.adapter.incoming.InventoryItemEventMessage

data class InventoryEventCommand(
    private val internalItemId: String,
    private val itemName: String,
    private val amount: Int,
    private val operation: Operation
) {


    enum class Operation {
        ADDED,
        SOLD
    }
}