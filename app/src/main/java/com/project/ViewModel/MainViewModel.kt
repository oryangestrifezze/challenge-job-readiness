package com.project.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.Data.MainRepository
import com.project.Model.*
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val repository = MainRepository()

    private var itemModelList: MutableLiveData<List<ItemModel>> = MutableLiveData(emptyList())
    val _itemModelList: LiveData<List<ItemModel>>
        get() {
            return itemModelList
        }

    fun getCategory(search: String) {
        viewModelScope.launch {
            itemModelList.value = repository.getCategory(search)
        }
    }

}
