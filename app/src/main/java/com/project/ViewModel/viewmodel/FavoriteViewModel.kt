package com.project.ViewModel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.Repository.data_source.MainRepository
import com.project.Repository.data.FavoriteApplication.Companion.favoritePreferences
import com.project.Repository.model.ItemModel
import kotlinx.coroutines.launch

class FavoriteViewModel : ViewModel(){

    private val repository = MainRepository()

    private var _itemsFavoritesModelList: MutableLiveData<List<ItemModel>> = MutableLiveData(emptyList())
    val itemsFavoritesModelList : LiveData<List<ItemModel>>
        get() {
            return _itemsFavoritesModelList
        }

    fun getFavoritesItems() {

        viewModelScope.launch {
            _itemsFavoritesModelList.value = repository.getFavoritesItems(favoritePreferences.getFavoritesItems().toList())
        }
    }

    fun removeFavorites(id: String) {
        favoritePreferences.removeFavoriteItem(id)
        _itemsFavoritesModelList.value = _itemsFavoritesModelList.value?.filter {
                it.id != id
            }
        }
}