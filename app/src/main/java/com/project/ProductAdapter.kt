package com.project

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.Model.ItemModel
import com.project.databinding.ProdutcItemBinding
import com.squareup.picasso.Picasso


class ProductAdapter(val clickedItem : (item: ItemModel) -> Unit) : RecyclerView.Adapter<ProductAdapter.ProductAdapterViewHolder>() {

    var listItems: List<ItemModel> = emptyList()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    fun interface onClick {
        fun itemClicked(item : ItemModel)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ProdutcItemBinding.inflate(inflater, parent, false)
        return ProductAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductAdapterViewHolder, position: Int) {
        if(listItems.isNotEmpty()) {
            holder.bind(listItems[position])
        }
    }

    override fun getItemCount() : Int = listItems.size

    inner class ProductAdapterViewHolder( val binding: ProdutcItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item : ItemModel) {
            //TODO: aqui continuar colocando valores do item
            binding.textTitle.text = item.title
            binding.textPrice.text = "R$ ${item.price}"

           Picasso.Builder(binding.root.context).build()
               .load(item.secure_thumbnail).into(binding.imageItem)

            binding.root.setOnClickListener {
                //TODO: retirar o teste de log
                //Log.d("Item Clicado", item.title.toString())

                clickedItem(item)
            }
        }
    }
}