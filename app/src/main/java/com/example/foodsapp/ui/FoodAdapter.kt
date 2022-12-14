package com.example.foodsapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodsapp.R
import com.example.foodsapp.data.util.asImageUrl
import com.example.foodsapp.databinding.ItemFoodBinding
import com.example.foodsapp.model.Food

class FoodAdapter(
    private val onFoodClick: (Food) -> Unit
) : ListAdapter<Food, FoodAdapter.FoodViewHolder>(Companion) {
    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) =
        holder.bind(getItem(position))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding, onFoodClick)
    }

    class FoodViewHolder(
        private val binding: ItemFoodBinding,
        private val onFoodClick: (Food) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(food: Food) = with(binding) {
            val context = binding.root.context

            Glide.with(context)
                .load(food.image.asImageUrl())
                .into(foodImageView)

            nameTextView.text = context.getString(R.string.name, food.name)
            priceTextView.text = context.getString(R.string.price, food.price)
            categoryTextView.text = context.getString(R.string.category, food.category)

            root.setOnClickListener { onFoodClick(food) }
        }
    }

    private companion object : DiffUtil.ItemCallback<Food>() {
        override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean =
            oldItem == newItem
    }
}
