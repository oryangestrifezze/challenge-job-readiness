package com.project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ProductDetailItem : Fragment() {

    //private var _binding: FragmentProductItemBinding? = null
   // private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //_binding = FragmentProductItemBinding.inflate(inflater, container, false)
        //return binding.root
        return inflater.inflate(R.layout.fragment_product_detail_item, container, false)
    }

}