package com.george.products.data.datasource

import com.george.products.domain.model.HomeFeedItemDM
import kotlinx.coroutines.flow.Flow

internal interface RemoteDS {

    suspend fun loadHomeFeed(): Flow<List<HomeFeedItemDM>>
}