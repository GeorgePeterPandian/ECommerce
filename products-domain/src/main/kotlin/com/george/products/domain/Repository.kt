package com.george.products.domain

import com.george.products.domain.model.HomeFeedItemDM
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun loadHomeFeed(): Flow<List<HomeFeedItemDM>>
}