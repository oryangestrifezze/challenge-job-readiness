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
            itemModelList.value.apply {
                this?.forEach {
                    it.description = repository.getDescriptionItem(it.id).plain_text
                }
            }
        }
    }

    fun verifyFavorites() {
        itemModelList.value = itemModelList.value.apply {
            this?.forEach {
                it.isFavorite = favoritePreferences.getFavoritesItems().contains(it.id)
            }
        }
    }

}
