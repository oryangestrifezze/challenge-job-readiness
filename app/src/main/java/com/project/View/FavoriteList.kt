package com.project.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.ViewModel.adapters.FavoriteAdapter
import com.project.ViewModel.viewmodel.FavoriteViewModel
import com.project.databinding.FragmentFavoriteListBinding


class FavoriteList : Fragment() {

    private val binding: FragmentFavoriteListBinding by lazy {
        FragmentFavoriteListBinding.inflate(layoutInflater)
    }

    private val viewmodel : FavoriteViewModel by viewModels()
    lateinit var adapter: FavoriteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = FavoriteAdapter()

        binding.recyclerViewList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewList.adapter = adapter

        viewmodel.itemsFavoritesModelList.observe(this) {
            binding.notFound.visibility = if(it.isEmpty()) View.VISIBLE else View.GONE
            adapter.listFavoriteItems = it
        }

       viewmodel.getFavoritesItems()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

}