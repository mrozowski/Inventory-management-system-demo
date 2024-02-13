package com.mrozowski.ims.adapter.outgoing.kafka

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.serialization.Serializer
import java.io.IOException

class InventoryUpdatedEventMessageSerializer : Serializer<InventoryUpdatedEventMessage> {
    private val objectMapper = ObjectMapper()

    override fun serialize(topic: String?, data: InventoryUpdatedEventMessage?): ByteArray {
        return try {
            objectMapper.writeValueAsBytes(data)
        } catch (e: IOException) {
            throw RuntimeException("Error serializing InventoryUpdatedEventMessage", e)
        }
    }
}