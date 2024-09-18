package com.george.products.data.service

import com.george.products.data.model.HomeFeedItemAM
import retrofit2.http.GET

interface Service {

    @GET("b/5BEJ")
    suspend fun loadHomeFeed(): List<HomeFeedItemAM>
}