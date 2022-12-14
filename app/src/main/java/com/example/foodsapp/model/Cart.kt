package com.example.foodsapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Cart(
    @SerialName("cartId") val cartId: Int,
    @SerialName("name") val name: String,
    @SerialName("image") val image: String,
    @SerialName("price") val price: Int,
    @SerialName("category") val category: String,
    @SerialName("orderAmount") val orderAmount: Int,
    @SerialName("userName") val userName: String
)
