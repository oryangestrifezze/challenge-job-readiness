package com.project.ViewModel.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.Repository.data.FavoriteApplication.Companion.favoritePreferences
import com.project.R
import com.project.Repository.data.FavoriteApplication
import com.project.Repository.model.ItemModel
import com.project.databinding.ProdutcItemBinding
import com.squareup.picasso.Picasso


class ProductAdapter(val clickedItem: (item: ItemModel) -> Unit) :
    RecyclerView.Adapter<ProductAdapter.ProductAdapterViewHolder>() {

    var listItems: List<ItemModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ProdutcItemBinding.inflate(inflater, parent, false)

        return ProductAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductAdapterViewHolder, position: Int) {
        if (listItems.isNotEmpty()) {
            holder.bind(listItems[position])
        }
    }

    override fun getItemCount(): Int = listItems.size

    inner class ProductAdapterViewHolder(val binding: ProdutcItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ItemModel) {

            val amout = item.price.toFloat().div(6)
            binding.textTitle.text = item.title
            binding.textPrice.text = "R$ ${item.price}"
            binding.textInstallmentAmount.text = "6 x R$ ${amout.toInt()} sem juros"
            Picasso.Builder(binding.root.context).build()
                .load(item.secure_thumbnail).into(binding.imageItem)

            if(item.isFavorite) binding.favoriteItem.setImageResource(R.drawable.full_favorite_icon)
                else {
                    binding.favoriteItem.setImageResource(R.drawable.favorite_icon)
                }

            binding.favoriteItem.setOnClickListener {
                var id = item.id
                if(favoritePreferences.getFavoritesItems().contains(id)) {
                    favoritePreferences.removeFavoriteItem(id)
                    binding.favoriteItem.setImageResource(R.drawable.favorite_icon)
                    item.isFavorite = false
                } else {
                    favoritePreferences.saveFavoriteItem(id)
                    binding.favoriteItem.setImageResource(R.drawable.full_favorite_icon)
                    item.isFavorite = true
                }
            }

            binding.root.setOnClickListener {
                clickedItem(item)
            }
        }
    }

}