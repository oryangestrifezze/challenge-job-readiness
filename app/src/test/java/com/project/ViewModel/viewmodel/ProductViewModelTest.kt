package com.project.ViewModel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.google.common.truth.Truth.assertThat
import com.project.Repository.data_source.MainRepository
import com.project.Repository.model.ItemModel
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

@RunWith(MockitoJUnitRunner::class)
class ProductViewModelTest {
    @Mock
    lateinit var repository: MainRepository
    private lateinit var viewModel: ProductViewModel

    @Before
    fun setup() {
        viewModel = ProductViewModel()
        repository = MainRepository()
    }

    @Test
    suspend fun getCategory_returnList() {
        //given
        val mockCategoryList = listOf(
            ItemModel("1", "Produto 1", "1000", "pic_image", "100", true, "descrição Produto"),
            ItemModel("2", "Produto 2", "1000", "pic_image", "100", true, "descrição Produto"),
            ItemModel("3", "Produto 3", "1000", "pic_image", "100", true, "descrição Produto"),
            ItemModel("4", "Produto 4", "1000", "pic_image", "100", true, "descrição Produto"),
            ItemModel("5", "Produto 5", "1000", "pic_image", "100", true, "descrição Produto"),
            )
        BDDMockito.given(repository.getCategory("")).willReturn(mockCategoryList)

        //when
        viewModel.getCategory("")

        //then
        var list =  LiveDataTestUtil.getValue(viewModel._itemModelList)
        assertThat(list).isEqualTo(mockCategoryList)
    }
}

object LiveDataTestUtil {

    /**
     * Get the value from a LiveData object. We're waiting for LiveData to emit, for 2 seconds.
     * Once we got a notification via onChanged, we stop observing.
     */
    fun <T> getValue(liveData: LiveData<T>): T {
        val data = arrayOfNulls<Any>(1)
        val latch = CountDownLatch(1)
        val observer = object : Observer<T> {
            override fun onChanged(o: T?) {
                data[0] = o
                latch.countDown()
                liveData.removeObserver(this)
            }
        }
        liveData.observeForever(observer)
        latch.await(2, TimeUnit.SECONDS)

        @Suppress("UNCHECKED_CAST")
        return data[0] as T
    }
}
