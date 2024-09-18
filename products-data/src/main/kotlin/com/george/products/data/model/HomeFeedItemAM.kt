package com.george.products.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeFeedItemAM(
    @SerialName("items")
    val items: List<ItemAM>? = emptyList(),
    @SerialName("sectionType")
    val sectionType: String? = ""
)