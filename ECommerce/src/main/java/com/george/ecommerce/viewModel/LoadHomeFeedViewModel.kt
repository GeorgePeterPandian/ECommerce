package com.george.ecommerce.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.george.core.domain.BusinessStates
import com.george.ecommerce.model.toHomeFeedItemUIM
import com.george.ecommerce.uiStates.HomeFeedUIStates
import com.george.products.domain.usecase.LoadHomeFeedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoadHomeFeedViewModel @Inject constructor(private val useCase: LoadHomeFeedUseCase) : ViewModel(){

    private var _uiState = MutableStateFlow(HomeFeedUIStates())
    val uiState = _uiState.asStateFlow()

    init {
        loadHomeFeed()
    }

    fun loadHomeFeed() {
        viewModelScope.launch {
            useCase.execute().collect { state ->
                when (state) {
                    is BusinessStates.Loading -> {
                        _uiState.update { it.copy(isLoading = true, error = "") }
                    }

                    is BusinessStates.Error -> {
                        _uiState.update {
                            it.copy(
                                isLoading = false, error = state.error.toString()
                            )
                        }
                    }

                    is BusinessStates.Success -> {
                        _uiState.update {
                            it.copy(
                                success = state.success?.toHomeFeedItemUIM(),
                                isLoading = false,
                                error = ""
                            )
                        }
                    }
                }
            }
        }
    }
}