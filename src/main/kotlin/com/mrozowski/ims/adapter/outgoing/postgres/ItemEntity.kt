package com.mrozowski.ims.adapter.outgoing.postgres

import jakarta.persistence.*

@Entity
@Table(name = "items")
data class ItemEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val itemId: Long? = null,

    @Column(name = "internal_id", nullable = false)
    val internalId: String,

    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "description")
    val description: String? = null,

    @Column(name = "quantity", nullable = false)
    var quantity: Int = 0,

    @Column(name = "price", nullable = false)
    val price: Int
)
