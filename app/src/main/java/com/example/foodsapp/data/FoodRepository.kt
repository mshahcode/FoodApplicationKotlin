package com.example.foodsapp.data

import javax.inject.Inject

class FoodRepository @Inject constructor(
    private val service: FoodService
) {
    suspend fun getFoods() = service.getFoods().body()

    suspend fun getFoodsCart(userName: String) = service.getFoodsCart(userName).body()

    suspend fun insertFood(
        name: String,
        image: String,
        price: Int,
        category: String,
        orderAmount: Int,
        userName: String
    ) = service.insertFood(name, image, price, category, orderAmount, userName)

    suspend fun deleteFood(cartId: Int, userName: String) = service.deleteFood(cartId, userName)
}
