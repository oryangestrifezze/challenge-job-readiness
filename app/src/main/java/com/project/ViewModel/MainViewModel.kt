package com.project.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.Data.MainRepository
import com.project.Model.*
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val repository = MainRepository()

    val categoryResponse = MutableLiveData<List<CategoryResponse>>()
    val highlightsResponseList = MutableLiveData<HighlightsResponse>()
    val categoryIdList = MutableLiveData<List<CategoryId>>()

    fun getCategory() {
        viewModelScope.launch {
            val result = repository.getCategory("Game")
            categoryResponse.value = result
        }
    }

    fun getHighlights() {
        viewModelScope.launch {
            val result = repository.getHighlights("MLB29344")
            highlightsResponseList.value = result
        }
    }

    fun getCategoryId() {
        viewModelScope.launch {
            val result = repository.getCategoryId("MLB793669133")
            categoryIdList.value = result
        }
    }
}
