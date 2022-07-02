package com.project.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.Repository.model.ItemModel
import com.project.ViewModel.adapters.ProductAdapter
import com.project.R
import com.project.ViewModel.viewmodel.ProductViewModel
import com.project.databinding.FragmentProductListBinding

class ProductList : Fragment() {

    private val binding: FragmentProductListBinding by lazy {
        FragmentProductListBinding.inflate(layoutInflater)
    }

    private val viewmodel: ProductViewModel by viewModels()

    lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        var searchView = binding.inputTextSearch

        adapter = ProductAdapter({ adapterOnClick(it) })

        binding.recyclerViewList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewList.adapter = adapter


        viewmodel._itemModelList.observe(this) {
            adapter.listItems = it
            binding.notFound.visibility = if (it.isEmpty()) View.VISIBLE else View.GONE
        }

        fun searchviewSetup() {
            searchView.clearFocus()

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(query: String): Boolean {
                    viewmodel.getCategory(query)
                    return false
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    return true
                }
            })
        }

        searchviewSetup()

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
        findNavController().navigate(
            R.id.action_productList_to_productDetailItem,
            bundleOf(
                "id" to item.id,
                "title" to item.title,
                "price" to item.price,
                "image" to item.secure_thumbnail,
                "available_quantity" to item.available_quantity
            )
        )
    }

}