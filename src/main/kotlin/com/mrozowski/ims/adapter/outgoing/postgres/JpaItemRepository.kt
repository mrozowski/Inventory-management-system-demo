package com.mrozowski.ims.adapter.outgoing.postgres

import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface JpaItemRepository : JpaRepository<ItemEntity, Long> {
    fun findByInternalId(internalId: String): ItemEntity?

    @Modifying
    @Transactional
    @Query("UPDATE ItemEntity i SET i.quantity = :newQuantity WHERE i.internalId = :internalId")
    fun updateQuantityByInternalId(internalId: String, newQuantity: Int): Int
}