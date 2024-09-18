package com.george.products.data

import com.george.products.data.datasource.RemoteDS
import com.george.products.domain.Repository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RepositoryImplTest {

    private lateinit var repository: Repository

    private val remoteDS: RemoteDS = mockk()

    @Before
    fun setUp() {
        repository = RepositoryImpl(remoteDS = remoteDS)
    }

    @Test
    fun `load all data of home feed successfully`() = runTest {
        //Given
        coEvery {
            repository.loadHomeFeed()
        } returns flow { emit(homeFeedItems) }

        //When
        val repositoryResults = repository.loadHomeFeed().first()

        //Then
        assertEquals(homeFeedItems, repositoryResults)
    }

    @Test
    fun `load all data of home feed successfully and check if the first block section type are same`() =
        runTest {
            //Given
            coEvery {
                repository.loadHomeFeed()
            } returns flow { emit(homeFeedItems) }

            //When
            val repositoryResults = repository.loadHomeFeed().first()

            //Then
            assertEquals(
                homeFeedItems.firstOrNull()?.sectionType,
                repositoryResults.firstOrNull()?.sectionType
            )
        }

    @Test
    fun `load all data of home feed successfully and check if the first block image are same`() =
        runTest {
            //Given
            coEvery {
                repository.loadHomeFeed()
            } returns flow { emit(homeFeedItems) }

            //When
            val repositoryResults = repository.loadHomeFeed().first()

            //Then
            assertEquals(
                homeFeedItems.firstOrNull()?.items?.firstOrNull()?.image,
                repositoryResults.firstOrNull()?.items?.firstOrNull()?.image
            )
        }

    @Test
    fun `load all data of home feed successfully and check if the first block title are same`() =
        runTest {
            //Given
            coEvery {
                repository.loadHomeFeed()
            } returns flow { emit(homeFeedItems) }

            //When
            val repositoryResults = repository.loadHomeFeed().first()

            //Then
            assertEquals(
                homeFeedItems.firstOrNull()?.items?.firstOrNull()?.title,
                repositoryResults.firstOrNull()?.items?.firstOrNull()?.title
            )
        }
}