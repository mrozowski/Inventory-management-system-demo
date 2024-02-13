package com.mrozowski.ims.domain.port

import com.mrozowski.ims.adapter.outgoing.postgres.ItemEntity
import com.mrozowski.ims.domain.model.Item

interface ItemRepository {

    fun getItemByInternalId(internalId: String): Item?
    fun updateQuantity(internalId: String, newQuantity: Int)
}