package com.george.ecommerce.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.george.ecommerce.model.ItemUIM

// Banner Section
@Composable
fun BannerSection(item: ItemUIM) {
    BannerImage(item)
}

@Composable
fun BannerImage(item: ItemUIM) {
    Column(
        modifier = Modifier
            .width(124.dp)
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = rememberAsyncImagePainter(item.image),
            contentDescription = item.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .padding(top = 16.dp, bottom = 16.dp)
        )

        Text(
            text = item.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(16.dp),
            fontSize = 14.sp
        )
    }
}