package com.project

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.Model.ItemModel
import com.project.ViewModel.MainViewModel
import com.project.databinding.FragmentProductListBinding

class ProductList : Fragment() {

    private val binding: FragmentProductListBinding by lazy {
        FragmentProductListBinding.inflate(layoutInflater)
    }

    private val viewmodel: MainViewModel by viewModels()

    lateinit var adapter : ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = ProductAdapter({ adapterOnClick(it) })

        binding.recyclerViewList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewList.adapter = adapter

        viewmodel._itemModelList.observe(this) {
            binding.notFound.visibility = if(it.isEmpty()) View.VISIBLE else View.GONE
            adapter.listItems = it
        }

        viewmodel.getCategory("Violoncelo")
        binding.allFavoriteItems.setOnClickListener {
            findNavController().navigate(R.id.action_productList_to_favoriteList)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    private fun adapterOnClick(item: ItemModel) {
        findNavController().navigate(R.id.action_productList_to_productDetailItem,
            bundleOf("title" to item.title, "price" to item.price, "image" to item.secure_thumbnail, "available_quantity" to item.available_quantity))
    }
}