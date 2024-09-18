package com.george.ecommerce.uiStates

import com.george.ecommerce.model.HomeFeedItemUIM


data class HomeFeedUIStates(
    val isLoading: Boolean = false,
    val error: String = "",
    var success: List<HomeFeedItemUIM>? = null
)
