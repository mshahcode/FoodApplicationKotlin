package com.example.foodsapp.ui.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodsapp.data.FoodRepository
import com.example.foodsapp.data.util.Constants.USERNAME
import com.example.foodsapp.model.Cart
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val foodRepository: FoodRepository
) : ViewModel() {
    private val _carts = MutableStateFlow<List<Cart>>(emptyList())
    val carts = _carts.asStateFlow()

    init {
        loadCarts()
    }

    private fun loadCarts() = viewModelScope.launch {
        try {
            val cartResponse = foodRepository.getFoodsCart(USERNAME)
            _carts.update { cartResponse?.foodsCart.orEmpty() }
        } catch (_: Exception) {
            _carts.update { emptyList() }
        }
    }

    fun refresh() {
        loadCarts()
    }

    fun deleteFood(cart: Cart) {
        viewModelScope.launch {
            foodRepository.deleteFood(cart.cartId, USERNAME)
            refresh()
        }
    }
}
