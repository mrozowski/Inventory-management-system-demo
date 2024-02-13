package com.mrozowski.ims.adapter.outgoing.kafka

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KafkaMessageMapperTest {

    private val underTest = KafkaMessageMapper()

    @Test
    fun `should map command to InventoryEventMessage`() {
        // Given
        val command = MessageFixtures.createInventoryEventUpdatedCommand()

        // When
        val message = underTest.createMessage(command)

        // Then
        assertEquals(command.internalId, message.internalId)
        assertEquals(command.itemName, message.itemName)
        assertEquals(command.currentQuantity, message.currentQuantity)
        assertEquals(MessageFixtures.KAFKA_MESSAGE_EVENT_TYPE, message.eventType)
    }
}