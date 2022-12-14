package com.example.foodsapp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodsapp.data.FoodRepository
import com.example.foodsapp.model.Food
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val foodRepository: FoodRepository
) : ViewModel() {
    private val _foods = MutableStateFlow<List<Food>>(emptyList())
    val foods = _foods.asStateFlow()

    init {
        loadFoods()
    }

    private fun loadFoods() = viewModelScope.launch {
        val foodResponse = foodRepository.getFoods()
        _foods.update { foodResponse?.foods.orEmpty() }
    }
}
