package com.george.products.data.datasource

import com.george.products.data.service.ApiService
import com.george.products.domain.model.HomeFeedItemDM
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class RemoteDSImpl @Inject constructor(private val apiService: ApiService): RemoteDS {

    override suspend fun loadHomeFeed(): Flow<List<HomeFeedItemDM>> = apiService.loadHomeFeed()
}