package com.george.ecommerce.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.george.ecommerce.model.HomeFeedItemUIM

// Content composable to handle loading and error states
@Composable
fun HomeFeedContent(homeFeedItems: List<HomeFeedItemUIM>, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        if (homeFeedItems.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Loading...", fontSize = 20.sp)
            }
        } else {
            HomeFeedScreen(homeFeedItems)
        }
    }
}

// Main composable to render the home feed
@Composable
fun HomeFeedScreen(homeFeedItems: List<HomeFeedItemUIM>) {
    LazyColumn {
        items(homeFeedItems) { homeFeedItem ->
            when (homeFeedItem.sectionType) {
                "horizontalFreeScroll" -> HorizontalFreeScrollSection(homeFeedItem.items)
                "splitBanner" -> SplitBannerSection(homeFeedItem.items)
                "banner" -> homeFeedItem.items.firstOrNull()?.let { BannerSection(it) }
            }
        }
    }
}