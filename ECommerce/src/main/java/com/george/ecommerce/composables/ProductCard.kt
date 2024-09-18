package com.george.ecommerce.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.george.ecommerce.model.ItemUIM

@Composable
fun ProductCard(item: ItemUIM) {
    Card(
        modifier = Modifier
            .width(124.dp)
            .height(124.dp)
            .padding(4.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = 4.dp
    ) {
        Image(
            painter = rememberAsyncImagePainter(item.image),
            contentDescription = item.title,
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
        )
    }
}