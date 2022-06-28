package com.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.project.ViewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val viewmodel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        viewmodel.categoryResponse.observe(this) {
            Log.d("TESTE", it[0].category_id.toString())
        }

        viewmodel.getCategory()

    }
}