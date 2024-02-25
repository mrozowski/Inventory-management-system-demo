package com.mrozowski.ims.adapter.incoming

import com.mrozowski.ims.domain.InventoryManagementSystemFacade
import com.mrozowski.ims.domain.model.InventoryEventCommand
import com.mrozowski.ims.infrastructure.logger
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component


@Component

class KafkaEventConsumer(private val facade: InventoryManagementSystemFacade) {
    private val logger = logger()

    @KafkaListener(topics = ["inventory-topic"], groupId = "ims-consumer-group")
    fun listen(message: InventoryItemEventMessage) {
        logger.info("Consumer triggered with message: $message")
        val command = InventoryEventCommand(
            message.internalItemId,
            message.itemName,
            message.amount,
            InventoryEventCommand.Operation.valueOf(message.operation.toString())
        )

        facade.processInventoryEvent(command)
    }

}

