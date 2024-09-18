package com.george.products.domain.usecase

import com.george.core.dispatchers.IoDispatcher
import com.george.core.domain.BusinessStates
import com.george.core.domain.ErrorEntities
import com.george.core.domain.FlowUseCase
import com.george.products.domain.Repository
import com.george.products.domain.model.HomeFeedItemDM
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

class LoadHomeFeedUseCase @Inject constructor(
    private val repository: Repository, @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : FlowUseCase<BusinessStates<List<HomeFeedItemDM>>>() {

    override fun execute(): Flow<BusinessStates<List<HomeFeedItemDM>>> = flow {
        emit(BusinessStates.Loading())
        try {
            repository.loadHomeFeed().collect { emit(BusinessStates.Success(it)) }
        } catch (exception: Exception) {
            when (exception) {
                is IOException -> emit(BusinessStates.Error(ErrorEntities.NetworkError))
                is CancellationException -> throw exception
                else -> emit(BusinessStates.Error(ErrorEntities.UnknownError))
            }
        }
    }.flowOn(ioDispatcher)
}