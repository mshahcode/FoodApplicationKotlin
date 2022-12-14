package com.example.foodsapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Food(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("image") val image: String,
    @SerialName("price") val price: Int,
    @SerialName("category") val category: String
) : java.io.Serializable
