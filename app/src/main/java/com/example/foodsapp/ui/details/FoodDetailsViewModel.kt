package com.example.foodsapp.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodsapp.data.FoodRepository
import com.example.foodsapp.data.util.Constants
import com.example.foodsapp.model.Food
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodDetailsViewModel @Inject constructor(
    private val foodRepository: FoodRepository
) : ViewModel() {
    fun addFoodToCart(food: Food, orderAmount: Int) {
        viewModelScope.launch {
            with(food) {
                foodRepository.insertFood(
                    name = name,
                    image = image,
                    price = price,
                    category = category,
                    orderAmount = orderAmount,
                    userName = Constants.USERNAME
                )
            }
        }
    }
}
