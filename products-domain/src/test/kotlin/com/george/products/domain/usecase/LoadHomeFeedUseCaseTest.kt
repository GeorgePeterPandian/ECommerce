package com.george.products.domain.usecase

import com.george.products.domain.Repository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

class LoadHomeFeedUseCaseTest {

    private lateinit var usecase: LoadHomeFeedUseCase

    private val repository: Repository = mockk()

    @OptIn(ExperimentalCoroutinesApi::class)
    private val iODispatcher: CoroutineDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        usecase = LoadHomeFeedUseCase(repository = repository, ioDispatcher = iODispatcher)
    }

    @Test
    fun `load all data of home feed successfully`() = runTest {
        //Given
        coEvery {
            repository.loadHomeFeed()
        } returns flow { emit(homeFeedItems) }

        //When
        val usecaseResults = usecase.execute().last()

        //Then
        assertEquals(homeFeedItems, usecaseResults.success)
    }

    @Test
    fun `load all data of home feed successfully and check if the first block section type are same`() =
        runTest {
            //Given
            coEvery {
                repository.loadHomeFeed()
            } returns flow { emit(homeFeedItems) }

            //When
            val usecaseResults = usecase.execute().last()

            //Then
            assertEquals(
                homeFeedItems.firstOrNull()?.sectionType,
                usecaseResults.success?.firstOrNull()?.sectionType
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
            val usecaseResults = usecase.execute().last()

            //Then
            assertEquals(
                homeFeedItems.firstOrNull()?.items?.firstOrNull()?.image,
                usecaseResults.success?.firstOrNull()?.items?.firstOrNull()?.image
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
            val usecaseResults = usecase.execute().last()

            //Then
            assertEquals(
                homeFeedItems.firstOrNull()?.items?.firstOrNull()?.title,
                usecaseResults.success?.firstOrNull()?.items?.firstOrNull()?.title
            )
        }
}