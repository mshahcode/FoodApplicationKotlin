package com.example.foodsapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FoodResponse(
    @SerialName("foods") val foods: List<Food>
)
