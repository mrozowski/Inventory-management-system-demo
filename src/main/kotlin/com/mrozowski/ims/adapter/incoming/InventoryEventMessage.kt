package com.mrozowski.ims.adapter.incoming

import com.fasterxml.jackson.annotation.JsonProperty

data class InventoryItemEventMessage(
    @get:JsonProperty("internalItemId") val internalItemId: String,
    @get:JsonProperty("itemName") val itemName: String,
    @get:JsonProperty("amount") val amount: Int,
    @get:JsonProperty("operation") val operation: Operation
) {

    constructor() : this("", "", 0, Operation.SOLD) {

    }

    override fun toString(): String {
        return "InventoryItemEventMessage(internalItemId='$internalItemId', itemName='$itemName', amount=$amount, operation=$operation)"
    }

    enum class Operation {
        ADDED,
        SOLD
    }
}