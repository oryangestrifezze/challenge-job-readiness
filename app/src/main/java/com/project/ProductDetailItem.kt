package com.project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.databinding.FragmentProductDetailItemBinding
import com.project.databinding.FragmentProductListBinding

class ProductDetailItem : Fragment() {

    private val binding: FragmentProductDetailItemBinding by lazy {
        FragmentProductDetailItemBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let { bundle ->
            binding.description.text = bundle.getString("title")
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