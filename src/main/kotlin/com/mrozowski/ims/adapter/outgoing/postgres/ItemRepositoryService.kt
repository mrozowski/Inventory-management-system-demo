package com.mrozowski.ims.adapter.outgoing.postgres

import com.mrozowski.ims.domain.model.Item
import com.mrozowski.ims.domain.port.ItemRepository
import com.mrozowski.ims.infrastructure.logger
import org.springframework.stereotype.Service

@Service
class ItemRepositoryService(
    private val itemRepository: JpaItemRepository,
    private val itemMapper: ItemMapper
) : ItemRepository {
    private val logger = logger()

    override fun getItemByInternalId(internalId: String): Item? {
        val itemEntity = itemRepository.findByInternalId(internalId)
        return itemEntity?.let { itemMapper.mapToInternal(it) }
    }

    override fun updateQuantity(internalId: String, newQuantity: Int) {
        val updatedRows = itemRepository.updateQuantityByInternalId(internalId, newQuantity)
        if (updatedRows > 0) {
            logger.info("Quantity of product [{}] updated. New Quantity: [{}]", internalId, newQuantity)
        } else {
            logger.error("Could not update Quantity of product [{}]", internalId)
        }
    }
}