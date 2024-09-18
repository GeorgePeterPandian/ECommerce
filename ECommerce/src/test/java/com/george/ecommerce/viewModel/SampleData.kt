package com.george.ecommerce.viewModel

import com.george.products.domain.model.HomeFeedItemDM
import com.george.products.domain.model.ItemDM

private val itemOne = ItemDM(image = "https://images.pexels.com/photos/7974/pexels-photo.jpg", title = "Laptop")

private val itemTwo = ItemDM(image = "https://images.pexels.com/photos/984619/pexels-photo-984619.jpeg", title = "Hat")

private val homeFeedItem = HomeFeedItemDM( items = listOf(itemOne, itemTwo) ,  sectionType = "banner")

internal val homeFeedItems = listOf(homeFeedItem)


