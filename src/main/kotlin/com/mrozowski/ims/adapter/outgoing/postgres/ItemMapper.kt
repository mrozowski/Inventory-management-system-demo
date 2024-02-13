package com.mrozowski.ims.adapter.outgoing.postgres

import com.mrozowski.ims.domain.model.Item
import org.springframework.stereotype.Component

@Component
class ItemMapper {
    fun mapToInternal(itemEntity: ItemEntity): Item {
        return Item(
            internalId = itemEntity.internalId,
            name = itemEntity.name,
            description = itemEntity.description,
            quantity = itemEntity.quantity,
            price = itemEntity.price
        )
    }

    fun mapToEntity(item: Item): ItemEntity {
        return ItemEntity(
            internalId = item.internalId,
            name = item.name,
            description = item.description,
            quantity = item.quantity,
            price = item.price
        )
    }
}