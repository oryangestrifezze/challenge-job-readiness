package com.project.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.R
import com.project.Repository.data.FavoriteApplication.Companion.favoritePreferences
import com.project.databinding.FragmentProductDetailItemBinding
import com.squareup.picasso.Picasso

class ProductDetailItem : Fragment() {


    private val binding: FragmentProductDetailItemBinding by lazy {
        FragmentProductDetailItemBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let { bundle ->
            val id = bundle.getString("id").toString()

            binding.price.text = "R$ ${bundle.getString("price")}"
            binding.quantidadeDisponivel.text = bundle.getString("available_quantity")
            binding.textDescription.text = bundle.getString("description").toString()

            Picasso.Builder(binding.root.context).build()
                .load(bundle.getString("image")).into(binding.image)

            if (favoritePreferences.getFavoritesItems()
                    .contains(id)
            ) binding.favoriteItem.setImageResource(R.drawable.full_favorite_icon)
            else {
                binding.favoriteItem.setImageResource(R.drawable.favorite_icon)
            }

            binding.favoriteItem.setOnClickListener {
                if (favoritePreferences.getFavoritesItems().contains(id)) {
                    favoritePreferences.removeFavoriteItem(id)
                    binding.favoriteItem.setImageResource(R.drawable.favorite_icon)

                } else {
                    favoritePreferences.saveFavoriteItem(id)
                    binding.favoriteItem.setImageResource(R.drawable.full_favorite_icon)
                }
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
}