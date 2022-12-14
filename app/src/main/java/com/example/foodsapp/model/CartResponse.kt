package com.example.foodsapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CartResponse(
    @SerialName("foods_cart") val foodsCart: List<Cart>
)
