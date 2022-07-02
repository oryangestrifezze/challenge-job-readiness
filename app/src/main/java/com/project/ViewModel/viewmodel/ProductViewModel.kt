package com.project.ViewModel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.Repository.data.FavoriteApplication
import com.project.Repository.data.FavoriteApplication.Companion.favoritePreferences
import com.project.Repository.data_source.MainRepository
import com.project.Repository.model.ItemModel
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {

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

    fun verifyFavorites() {
        val listFavorites = favoritePreferences.getFavoritesItems()
        itemModelList.value = itemModelList.value.apply {
            this?.forEach {
                it.isFavorite = listFavorites.contains(it.id)
            }
        }
        println(_itemModelList.value)
    }

}
