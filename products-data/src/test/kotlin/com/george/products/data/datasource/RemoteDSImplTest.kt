package com.george.products.data.datasource

import com.george.products.data.homeFeedItems
import com.george.products.data.service.ApiService
import io.mockk.coEvery
import io.mockk.spyk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RemoteDSImplTest {

    private lateinit var remoteDS: RemoteDS

    private val apiService: ApiService = spyk()

    @Before
    fun setUp() {
        remoteDS = RemoteDSImpl(apiService = apiService)
    }

    @Test
    fun `load all data of home feed successfully`() = runTest {
        //Given
        coEvery {
            remoteDS.loadHomeFeed()
        } returns flow { emit(homeFeedItems) }

        //When
        val remoteResults = remoteDS.loadHomeFeed().first()

        //Then
        assertEquals(homeFeedItems, remoteResults)
    }

    @Test
    fun `load all data of home feed successfully and check if the first block section type are same`() =
        runTest {
            //Given
            coEvery {
                remoteDS.loadHomeFeed()
            } returns flow { emit(homeFeedItems) }

            //When
            val remoteResults = remoteDS.loadHomeFeed().first()

            //Then
            assertEquals(
                homeFeedItems.firstOrNull()?.sectionType, remoteResults.firstOrNull()?.sectionType
            )
        }

    @Test
    fun `load all data of home feed successfully and check if the first block image are same`() =
        runTest {
            //Given
            coEvery {
                remoteDS.loadHomeFeed()
            } returns flow { emit(homeFeedItems) }

            //When
            val remoteResults = remoteDS.loadHomeFeed().first()

            //Then
            assertEquals(
                homeFeedItems.firstOrNull()?.items?.firstOrNull()?.image,
                remoteResults.firstOrNull()?.items?.firstOrNull()?.image
            )
        }

    @Test
    fun `load all data of home feed successfully and check if the first block title are same`() =
        runTest {
            //Given
            coEvery {
                remoteDS.loadHomeFeed()
            } returns flow { emit(homeFeedItems) }

            //When
            val remoteResults = remoteDS.loadHomeFeed().first()

            //Then
            assertEquals(
                homeFeedItems.firstOrNull()?.items?.firstOrNull()?.title,
                remoteResults.firstOrNull()?.items?.firstOrNull()?.title
            )
        }
}