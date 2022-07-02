package com.project.ViewModel.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.project.ViewModel.viewmodel.FavoriteViewModel
import com.project.Repository.data.FavoriteApplication.Companion.favoritePreferences
import com.project.Repository.model.ItemModel

import com.project.databinding.FavoriteItemBinding
import com.squareup.picasso.Picasso

class FavoriteAdapter : RecyclerView.Adapter<FavoriteAdapter.FavoriteAdapterViewHolder>() {

    var listFavoriteItems: List<ItemModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteAdapterViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        val binding = FavoriteItemBinding.inflate(inflater, parent, false)
        return FavoriteAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteAdapterViewHolder, position: Int) {
        if (listFavoriteItems.isNotEmpty()) {
            holder.bind(listFavoriteItems[position])
        }
    }

    override fun getItemCount(): Int = listFavoriteItems.size

    inner class FavoriteAdapterViewHolder(val binding: FavoriteItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemModel) {
            binding.textTitle.text = item.title
            binding.textPrice.text = "R$ ${item.price}"

            Picasso.Builder(binding.root.context).build()
                .load(item.secure_thumbnail).into(binding.imageItem)

            binding.buttonExcluir.setOnClickListener {
                var id = item.id
                    favoritePreferences.removeFavoriteItem(id)
                    item.isFavorite = false

                }


            }
    }

}




