package com.project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.databinding.FragmentProductListBinding

class ProductList : Fragment() {

    private val binding: FragmentProductListBinding by lazy {
        FragmentProductListBinding.inflate(layoutInflater)
    }

     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }



}