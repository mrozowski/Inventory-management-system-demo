package com.mrozowski.ims.adapter.incoming

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.serialization.Deserializer
import java.io.IOException

class InventoryItemEventMessageDeserializer : Deserializer<InventoryItemEventMessage> {
    private val objectMapper = ObjectMapper()

    override fun deserialize(topic: String?, data: ByteArray?): InventoryItemEventMessage {
        return try {
            objectMapper.readValue(data, InventoryItemEventMessage::class.java)
        } catch (e: IOException) {
            throw RuntimeException("Error deserializing InventoryItemEventMessage", e)
        }
    }
}