package com.george.ecommerce.model

import com.george.products.domain.model.HomeFeedItemDM
import com.george.products.domain.model.ItemDM

internal fun List<HomeFeedItemDM>.toHomeFeedItemUIM() = map { it.toHomeFeedItemsUIM() }

private fun HomeFeedItemDM.toHomeFeedItemsUIM() = HomeFeedItemUIM(
    items = items.toItemsUIM(),
    sectionType = sectionType
)

private fun List<ItemDM>.toItemsUIM() = map { it.toItemUIM() }

private fun ItemDM.toItemUIM() = ItemUIM(
    image = image,
    title = title
)