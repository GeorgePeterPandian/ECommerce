package com.george.ecommerce

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.george.ecommerce.composables.HomeFeedContent
import com.george.ecommerce.composables.HomeFeedScreen
import com.george.ecommerce.model.HomeFeedItemUIM
import com.george.ecommerce.model.ItemUIM
import com.george.ecommerce.ui.theme.ECommerceTheme
import com.george.ecommerce.viewModel.LoadHomeFeedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<LoadHomeFeedViewModel>()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            ECommerceTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
                    TopAppBar(
                        title = {
                            Box(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = stringResource(R.string.app_name),
                                    style = MaterialTheme.typography.h6
                                )
                            }
                        }, elevation = 4.dp
                    )
                }) { innerPadding ->
                    HomeFeedContent(
                        homeFeedItems = uiState.success ?: emptyList(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


// Preview function for development
@Preview(showBackground = true)
@Composable
fun PreviewHomeFeed() {
    ECommerceTheme {
        HomeFeedScreen(
            listOf(
                HomeFeedItemUIM(
                    items = listOf(
                        ItemUIM(
                            image = "https://images.pexels.com/photos/789812/pexels-photo-789812.jpeg",
                            title = "Product 1"
                        ), ItemUIM(
                            image = "https://images.pexels.com/photos/789812/pexels-photo-789812.jpeg",
                            title = "Product 2"
                        )
                    ), sectionType = "horizontalFreeScroll"
                ), HomeFeedItemUIM(
                    items = listOf(
                        ItemUIM(
                            image = "https://images.pexels.com/photos/789812/pexels-photo-789812.jpeg",
                            title = "Banner 1"
                        ), ItemUIM(
                            image = "https://images.pexels.com/photos/789812/pexels-photo-789812.jpeg",
                            title = "Banner 2"
                        )
                    ), sectionType = "splitBanner"
                ), HomeFeedItemUIM(
                    items = listOf(
                        ItemUIM(
                            image = "https://images.pexels.com/photos/789812/pexels-photo-789812.jpeg",
                            title = "Full Banner"
                        )
                    ), sectionType = "banner"
                )
            )
        )
    }
}