package com.mrozowski.ims.adapter.outgoing.postgres

import com.mrozowski.ims.domain.model.Item

object ItemFixtures {
    private const val INTERNAL_ID = "123456"
    private const val NAME = "Test Item"
    private const val DESCRIPTION = "Sample description"
    private const val QUANTITY = 10
    private const val PRICE = 100

    fun createSampleItemEntity(): ItemEntity {
        return ItemEntity(
            internalId = INTERNAL_ID,
            name = NAME,
            description = DESCRIPTION,
            quantity = QUANTITY,
            price = PRICE
        )
    }

    fun createSampleItem(): Item {
        return Item(
            internalId = INTERNAL_ID,
            name = NAME,
            description = DESCRIPTION,
            quantity = QUANTITY,
            price = PRICE
        )
    }
}