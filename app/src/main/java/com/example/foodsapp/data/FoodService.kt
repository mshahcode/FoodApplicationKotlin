package com.example.foodsapp.data

import com.example.foodsapp.model.CartResponse
import com.example.foodsapp.model.FoodResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface FoodService {
    @GET("foods/getAllFoods.php")
    suspend fun getFoods(): Response<FoodResponse>

    @FormUrlEncoded
    @POST("foods/getFoodsCart.php")
    suspend fun getFoodsCart(@Field("userName") userName: String): Response<CartResponse>

    @FormUrlEncoded
    @POST("foods/insertFood.php")
    suspend fun insertFood(
        @Field("name") name: String,
        @Field("image") image: String,
        @Field("price") price: Int,
        @Field("category") category: String,
        @Field("orderAmount") orderAmount: Int,
        @Field("userName") userName: String
    )

    @FormUrlEncoded
    @POST("foods/deleteFood.php")
    suspend fun deleteFood(
        @Field("cartId") cartId: Int,
        @Field("userName") userName: String
    )
}
