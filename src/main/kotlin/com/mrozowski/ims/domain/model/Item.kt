package com.mrozowski.ims.domain.model

data class Item(
    val internalId: String,
    val name: String,
    val description: String?,
    var quantity: Int,
    val price: Int
)