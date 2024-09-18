package com.george.products.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemAM(
    @SerialName("image")
    val image: String? = "",
    @SerialName("title")
    val title: String? = ""
)