package com.project.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.Data.MainRepository
import com.project.Model.CategoryIdResponse
import com.project.Model.CategoryResponse
import com.project.Model.HighlightsResponse
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val repository = MainRepository()

    val categoryResponse = MutableLiveData<List<CategoryResponse>>()
    val categoryIdList = MutableLiveData<List<CategoryIdResponse>>()
    val highlightsResponseList = MutableLiveData<List<HighlightsResponse>>()

    fun getCategory() {
        viewModelScope.launch {
            val result = repository.getCategory()
            categoryResponse.value = result
        }
    }

    fun getCategoryId() {
        viewModelScope.launch {
            val result = repository.getCategoryId()
            categoryIdList.value = result
        }
    }

    fun getHighlights() {
        viewModelScope.launch {
            val result = repository.getHighlights()
            highlightsResponseList.value = result
        }
    }
}
