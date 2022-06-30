package com.project

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.FavoriteApplication.Companion.favoritePreferences
import com.project.Model.ItemModel
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
            binding.textTitle.text = item.title
            binding.textPrice.text = "R$ ${item.price}"

            Picasso.Builder(binding.root.context).build()
                .load(item.secure_thumbnail).into(binding.imageItem)

            binding.favoriteItem.setOnClickListener {
                var id = item.id
                var list = favoritePreferences.getFavoritesItems()

                if(list.contains(id)) {
                    favoritePreferences.removeFavoriteItem(id)
                    binding.favoriteItem.setImageResource(R.drawable.favorite_icon)
                } else {
                    favoritePreferences.saveFavoriteItem(id)
                    binding.favoriteItem.setImageResource(R.drawable.full_favorite_icon)
                }
            }

            binding.root.setOnClickListener {
                clickedItem(item)
            }
        }
    }
}