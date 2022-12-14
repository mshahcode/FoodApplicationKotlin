package com.example.foodsapp.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodsapp.R
import com.example.foodsapp.data.util.asImageUrl
import com.example.foodsapp.databinding.ItemCartBinding
import com.example.foodsapp.model.Cart

class CartAdapter(
    private val onDeleteClick: (Cart) -> Unit
) : ListAdapter<Cart, CartAdapter.CartViewHolder>(Companion) {
    override fun onBindViewHolder(holder: CartViewHolder, position: Int) =
        holder.bind(getItem(position))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding, onDeleteClick)
    }

    class CartViewHolder(
        private val binding: ItemCartBinding,
        private val onDeleteClick: (Cart) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cart: Cart) = with(binding) {
            val context = root.context

            Glide.with(context)
                .load(cart.image.asImageUrl())
                .into(foodImageView)

            nameTextView.text = context.getString(R.string.name, cart.name)
            priceTextView.text = context.getString(R.string.price, cart.price)
            categoryTextView.text = context.getString(R.string.category, cart.category)
            orderAmountTextView.text = context.getString(R.string.order_amount, cart.orderAmount)

            deleteButton.setOnClickListener { onDeleteClick(cart) }
        }
    }

    private companion object : DiffUtil.ItemCallback<Cart>() {
        override fun areItemsTheSame(oldItem: Cart, newItem: Cart): Boolean =
            oldItem.cartId == newItem.cartId

        override fun areContentsTheSame(oldItem: Cart, newItem: Cart): Boolean =
            oldItem == newItem
    }
}
