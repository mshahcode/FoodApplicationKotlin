package com.example.foodsapp.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.foodsapp.R
import com.example.foodsapp.data.util.asImageUrl
import com.example.foodsapp.databinding.FragmentFoodDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodDetailsFragment : Fragment() {
    private var _binding: FragmentFoodDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FoodDetailsViewModel by hiltNavGraphViewModels(R.id.nav_graph)
    private val args: FoodDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFoodDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupFood()
    }

    private fun setupFood() = with(binding) {
        val context = requireContext()
        val food = args.food

        with(foodView) {
            Glide.with(context)
                .load(food.image.asImageUrl())
                .into(foodImageView)

            nameTextView.text = context.getString(R.string.name, food.name)
            priceTextView.text = context.getString(R.string.price, food.price)
            categoryTextView.text = context.getString(R.string.category, food.category)
        }

        addToCartButton.setOnClickListener {
            val orderAmount = amountEditText.text.toString().toInt()
            viewModel.addFoodToCart(food, orderAmount)
            amountEditText.text?.clear()
            Toast.makeText(
                context,
                "The ${food.name} food with the $orderAmount amount has been added to your cart",
                Toast.LENGTH_LONG
            ).show()
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
