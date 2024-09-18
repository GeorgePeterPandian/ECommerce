package com.george.products.data.service

import com.george.products.data.homeFeedItems
import io.mockk.coEvery
import io.mockk.spyk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ApiServiceTest {

    private lateinit var apiService: ApiService

    @Before
    fun setUp() {
        apiService = spyk()
    }

    @Test
    fun `load all data of home feed successfully`() = runTest {
        //Given
        coEvery {
            apiService.loadHomeFeed()
        } returns flow { emit(homeFeedItems) }

        //When
        val apiServiceResults = apiService.loadHomeFeed().first()

        //Then
        assertEquals(homeFeedItems, apiServiceResults)
    }

    @Test
    fun `load all data of home feed successfully and check if the first block section type are same`() =
        runTest {
            //Given
            coEvery {
                apiService.loadHomeFeed()
            } returns flow { emit(homeFeedItems) }

            //When
            val apiServiceResults = apiService.loadHomeFeed().first()

            //Then
            assertEquals(
                homeFeedItems.firstOrNull()?.sectionType,
                apiServiceResults.firstOrNull()?.sectionType
            )
        }

    @Test
    fun `load all data of home feed successfully and check if the first block image are same`() =
        runTest {
            //Given
            coEvery {
                apiService.loadHomeFeed()
            } returns flow { emit(homeFeedItems) }

            //When
            val apiServiceResults = apiService.loadHomeFeed().first()

            //Then
            assertEquals(
                homeFeedItems.firstOrNull()?.items?.firstOrNull()?.image,
                apiServiceResults.firstOrNull()?.items?.firstOrNull()?.image
            )
        }

    @Test
    fun `load all data of home feed successfully and check if the first block title are same`() =
        runTest {
            //Given
            coEvery {
                apiService.loadHomeFeed()
            } returns flow { emit(homeFeedItems) }

            //When
            val apiServiceResults = apiService.loadHomeFeed().first()

            //Then
            assertEquals(
                homeFeedItems.firstOrNull()?.items?.firstOrNull()?.title,
                apiServiceResults.firstOrNull()?.items?.firstOrNull()?.title
            )
        }
}