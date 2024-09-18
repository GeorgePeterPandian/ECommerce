package com.george.products.data.model

import com.george.products.domain.model.HomeFeedItemDM
import com.george.products.domain.model.ItemDM

internal fun List<HomeFeedItemAM>.toListHomeFeedItemsDM() = map { it.toHomeFeedItemsDM() }

internal fun HomeFeedItemAM.toHomeFeedItemsDM() = HomeFeedItemDM(
    items = items?.toItemsDM().orEmpty(),
    sectionType = sectionType.orEmpty()
)

private fun List<ItemAM>.toItemsDM() = map { it.toItemDM() }

private fun ItemAM.toItemDM() = ItemDM(
    image = image.orEmpty(),
    title = title.orEmpty()
)