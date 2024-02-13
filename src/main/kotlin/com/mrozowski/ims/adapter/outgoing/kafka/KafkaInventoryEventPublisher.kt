package com.mrozowski.ims.adapter.outgoing.kafka

import com.mrozowski.ims.domain.model.InventoryEventUpdatedCommand
import com.mrozowski.ims.domain.port.InventoryEventPublisher
import com.mrozowski.ims.infrastructure.logger
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaInventoryEventPublisher(
    private val kafkaTemplate: KafkaTemplate<String, InventoryUpdatedEventMessage>,
    private val mapper: KafkaMessageMapper
) :
    InventoryEventPublisher {
    private val logger = logger()

    override suspend fun publishInventoryUpdatedEvent(event: InventoryEventUpdatedCommand) {
        val message = mapper.createMessage(event)

        logger.info(
            "Sending InventoryEventMessage for item: [{}] and event type [{}]", message.internalId, message.eventType
        )
        kafkaTemplate.send("inventory_updated_topic", message)
        logger.info("Message for item [{}] sent", message.internalId)
    }
}