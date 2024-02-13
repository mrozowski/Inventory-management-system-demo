package com.mrozowski.ims.adapter.outgoing.postgres

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ItemMapperTest {
    private val underTest = ItemMapper()

    @Test
    fun `should map ItemEntity to Item`() {
        // Given
        val itemEntity = ItemFixtures.createSampleItemEntity()

        // When
        val item = underTest.mapToInternal(itemEntity)

        // Then
        assertEquals(itemEntity.internalId, item.internalId)
        assertEquals(itemEntity.name, item.name)
        assertEquals(itemEntity.description, item.description)
        assertEquals(itemEntity.quantity, item.quantity)
        assertEquals(itemEntity.price, item.price)
    }

    @Test
    fun `should map Item to ItemEntity`() {
        // Given
        val item = ItemFixtures.createSampleItem()

        // When
        val itemEntity = underTest.mapToEntity(item)

        // Then
        assertEquals(item.internalId, itemEntity.internalId)
        assertEquals(item.name, itemEntity.name)
        assertEquals(item.description, itemEntity.description)
        assertEquals(item.quantity, itemEntity.quantity)
        assertEquals(item.price, itemEntity.price)
    }
}
