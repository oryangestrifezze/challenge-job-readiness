package com.project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.databinding.FragmentProductDetailItemBinding
import com.project.databinding.FragmentProductListBinding
import com.squareup.picasso.Picasso

class ProductDetailItem : Fragment() {

    private val binding: FragmentProductDetailItemBinding by lazy {
        FragmentProductDetailItemBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let { bundle ->
            binding.price.text = "R$ ${bundle.getString("price")}"
            binding.quantidadeDisponivel.text = bundle.getString("available_quantity")

            Picasso.Builder(binding.root.context).build()
                .load(bundle.getString("image")).into(binding.image)
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