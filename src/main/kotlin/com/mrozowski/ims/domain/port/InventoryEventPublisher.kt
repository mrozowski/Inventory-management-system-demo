package com.mrozowski.ims.domain.port

import com.mrozowski.ims.domain.model.InventoryEventUpdatedCommand

interface InventoryEventPublisher {

    suspend fun publishInventoryUpdatedEvent(event: InventoryEventUpdatedCommand)
}