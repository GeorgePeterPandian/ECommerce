package com.george.products.data

import com.george.products.data.datasource.RemoteDS
import com.george.products.domain.Repository
import com.george.products.domain.model.HomeFeedItemDM
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class RepositoryImpl @Inject constructor(private val remoteDS: RemoteDS) : Repository{

    override suspend fun loadHomeFeed(): Flow<List<HomeFeedItemDM>> = remoteDS.loadHomeFeed()
}