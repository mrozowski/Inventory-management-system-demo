package com.mrozowski.ims.domain

import com.mrozowski.ims.domain.model.InventoryEventCommand
import com.mrozowski.ims.domain.model.Item
import com.mrozowski.ims.domain.port.InventoryEventPublisher
import com.mrozowski.ims.domain.port.ItemRepository
import com.mrozowski.ims.infrastructure.logger
import org.springframework.stereotype.Component

@Component
class InventoryManagementSystemFacade(private val itemService: ItemService) {
    private val logger = logger()

    fun processInventoryEvent(command: InventoryEventCommand) {
        itemService.processInventoryEvent(command)
        logger.info("Event processing for item [{}] has been finished", command.internalItemId)
    }
}
