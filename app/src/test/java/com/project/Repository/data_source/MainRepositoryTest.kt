package com.project.Repository.data_source

import com.project.Repository.data_source.MainRepository
import com.project.Repository.model.ItemModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

@Test
fun MainRepositoryTest() = runTest {
    val userRepo = MainRepository()
    var response: List<ItemModel> = emptyList()
    launch { response = userRepo.getCategory("Game") }
    advanceUntilIdle() // Yields to perform the registrations

    assertEquals(response.size, 1)// ✅ Passes
}

