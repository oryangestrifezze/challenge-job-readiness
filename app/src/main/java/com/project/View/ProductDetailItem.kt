package com.project.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.Repository.data.FavoriteApplication
import com.project.R
import com.project.databinding.FragmentProductDetailItemBinding
import com.squareup.picasso.Picasso

class ProductDetailItem : Fragment() {
    var list = FavoriteApplication.favoritePreferences.getFavoritesItems()

    private val binding: FragmentProductDetailItemBinding by lazy {
        FragmentProductDetailItemBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let { bundle ->
            binding.price.text = "R$ ${bundle.getString("price")}"
            binding.quantidadeDisponivel.text = bundle.getString("available_quantity")

            Picasso.Builder(binding.root.context).build()
                .load(bundle.getString("image")).into(binding.image)

            if (list.contains(bundle.getString("id"))) {
                binding.favoriteItem.setImageResource(R.drawable.full_favorite_icon)
            } else {
                binding.favoriteItem.setImageResource(R.drawable.favorite_icon)
            }
        }

        binding.favoriteItem.setOnClickListener {
            var newList = FavoriteApplication.favoritePreferences.getFavoritesItems()
            var id = it.id.toString()
            if (newList.contains(id)) {
                FavoriteApplication.favoritePreferences.removeFavoriteItem(id)
                binding.favoriteItem.setImageResource(R.drawable.favorite_icon)
            } else {
                FavoriteApplication.favoritePreferences.saveFavoriteItem(id)
                binding.favoriteItem.setImageResource(R.drawable.full_favorite_icon)
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