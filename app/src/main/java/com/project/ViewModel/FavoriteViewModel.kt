package com.project.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.Data.MainRepository
import com.project.FavoriteApplication.Companion.favoritePreferences
import com.project.Model.ItemModel
import kotlinx.coroutines.launch

class FavoriteViewModel : ViewModel(){

    private val repository = MainRepository()

    private var idsFavoriteItems: List<String> = favoritePreferences.getFavoritesItems()

    private var _itemsFavoritesModelList: MutableLiveData<List<ItemModel>> = MutableLiveData(emptyList())

    val itemsFavoritesModelList : LiveData<List<ItemModel>>
        get() {
            return _itemsFavoritesModelList
        }

    fun getFavoritesItems() {
        viewModelScope.launch {
            _itemsFavoritesModelList.value = repository.getFavoritesItems(idsFavoriteItems)
        }
    }

}