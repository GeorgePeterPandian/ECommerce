package com.george.ecommerce.viewModel

import com.george.core.domain.BusinessStates
import com.george.core.test.CoroutineTestRule
import com.george.products.domain.Repository
import com.george.products.domain.model.HomeFeedItemDM
import com.george.products.domain.usecase.LoadHomeFeedUseCase
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.spyk
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class LoadHomeFeedViewModelTest {

    private lateinit var viewModel: LoadHomeFeedViewModel

    @get:Rule
    val coroutineDispatcherRule = CoroutineTestRule()

    private val repository: Repository = mockk()

    private val iODispatcher: CoroutineDispatcher = UnconfinedTestDispatcher()

    private val useCase: LoadHomeFeedUseCase = spyk(LoadHomeFeedUseCase(repository, iODispatcher))

    @Before
    fun setUp() {
        viewModel = LoadHomeFeedViewModel(useCase)
    }

    @Test
    fun `emit loading ui state when the use case emits loading business state`() = runTest {
        //Given
        val loadingBusinessState = BusinessStates.Loading<List<HomeFeedItemDM>>()
        coEvery {
            useCase.execute()
        } returns flow { emit(loadingBusinessState) }

        //When
        viewModel.loadHomeFeed()

        //Then
        assertEquals(viewModel.uiState.value.isLoading, true)
    }

    @Test
    fun `emit success ui state when the use case emits success business state and check if the first block section type are same`() =
        runTest {
            //Given
            val successBusinessState = BusinessStates.Success(homeFeedItems)
            coEvery {
                useCase.execute()
            } returns flow { emit(successBusinessState) }

            //When
            viewModel.loadHomeFeed()

            //Then
            assertEquals(
                homeFeedItems.firstOrNull()?.sectionType,
                viewModel.uiState.value.success?.firstOrNull()?.sectionType
            )
        }

    @Test
    fun `emit success ui state when the use case emits success business state and check if the first block section image are same`() =
        runTest {
            //Given
            val successBusinessState = BusinessStates.Success(homeFeedItems)
            coEvery {
                useCase.execute()
            } returns flow { emit(successBusinessState) }

            //When
            viewModel.loadHomeFeed()

            //Then
            assertEquals(
                homeFeedItems.firstOrNull()?.items?.firstOrNull()?.image,
                viewModel.uiState.value.success?.firstOrNull()?.items?.firstOrNull()?.image
            )
        }

    @Test
    fun `emit success ui state when the use case emits success business state and check if the first block section title are same`() =
        runTest {
            //Given
            val successBusinessState = BusinessStates.Success(homeFeedItems)
            coEvery {
                useCase.execute()
            } returns flow { emit(successBusinessState) }

            //When
            viewModel.loadHomeFeed()

            //Then
            assertEquals(
                homeFeedItems.firstOrNull()?.items?.firstOrNull()?.title,
                viewModel.uiState.value.success?.firstOrNull()?.items?.firstOrNull()?.title
            )
        }
}