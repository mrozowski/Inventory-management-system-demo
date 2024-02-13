package com.mrozowski.ims.domain

import com.mrozowski.ims.domain.model.InventoryEventCommand
import com.mrozowski.ims.domain.model.InventoryEventUpdatedCommand.EventType
import com.mrozowski.ims.domain.model.Item
import com.mrozowski.ims.domain.port.InventoryEventPublisher
import com.mrozowski.ims.domain.port.ItemRepository
import com.mrozowski.ims.infrastructure.logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.springframework.stereotype.Service

@Service
class ItemService(
    private val itemRepository: ItemRepository,
    private val eventPublisher: InventoryEventPublisher,
    private val commandMapper: CommandMapper
) {
    private val minQuantity: Int = 10
    private val logger = logger()
    private val coroutineScope = CoroutineScope(Dispatchers.Default)

    fun processInventoryEvent(command: InventoryEventCommand) {
        val item = itemRepository.getItemByInternalId(command.internalItemId)

        item?.let {
            when (command.operation) {
                InventoryEventCommand.Operation.ADDED -> handleItemAdded(it, command.amount)
                InventoryEventCommand.Operation.SOLD -> handleItemSold(it, command.amount)
            }
        } ?: run {
            logger.error("Item with internal id [{}] not found", command.internalItemId)
        }
    }

    private fun handleItemAdded(item: Item, amount: Int) {
        item.quantity += amount
        itemRepository.updateQuantity(item.internalId, item.quantity)
        publishUpdatedItemEvent(item)
    }

    private fun handleItemSold(item: Item, amount: Int) {
        if (item.quantity < amount) {
            logger.error(
                "Item with internalId [{}] has quantity [{}] but amount sold is [{}]",
                item.internalId, item.quantity, amount
            )
            item.quantity = 0
            logger.warn("Setting item [{}] quantity to zero", item.internalId)
        } else {
            item.quantity -= amount
        }

        itemRepository.updateQuantity(item.internalId, item.quantity)

        if (item.quantity == 0) publishEmptyInventoryAlert(item)
        else if (item.quantity < minQuantity) publishLowInventoryAlert(item)
        else publishUpdatedItemEvent(item)
    }

    private fun publishUpdatedItemEvent(item: Item) {
        coroutineScope.launch {
            val command = commandMapper.toInventoryEventUpdatedCommand(item, EventType.UPDATED)
            eventPublisher.publishInventoryUpdatedEvent(command)
        }
    }

    private fun publishEmptyInventoryAlert(item: Item) {
        coroutineScope.launch {
            val command = commandMapper.toInventoryEventUpdatedCommand(item, EventType.EMPTY_INVENTORY)
            eventPublisher.publishInventoryUpdatedEvent(command)
        }
    }

    private fun publishLowInventoryAlert(item: Item) {
        coroutineScope.launch {
            val command = commandMapper.toInventoryEventUpdatedCommand(item, EventType.LOW_INVENTORY)
            eventPublisher.publishInventoryUpdatedEvent(command)
        }
    }
}