/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.miniact3.ui.theme

import ImageScreenUiState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.miniact3.R


@Composable
fun ImageScreen(
    imageScreenUiState: ImageScreenUiState,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    AsyncImage(model = ImageRequest.Builder(LocalContext.current)
        .data("https://s.inyourpocket.com/gallery/113383.jpg")
        .crossfade(true)
        .build(),
        error = painterResource(R.drawable.ic_broken_image),
        placeholder = painterResource(R.drawable.loading_img),
        contentDescription = "stringResource(R.string.description)",
        contentScale = ContentScale.Fit,
        modifier = modifier.fillMaxSize()
    )
       /* when (imageScreenUiState) {
            is ImageScreenUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
            is ImageScreenUiState.Success -> ResultScreen(
                imageScreenUiState.photos, modifier = modifier
                    .fillMaxWidth()

            )

            is ImageScreenUiState.Error -> ErrorScreen(modifier = modifier.fillMaxSize())
            else -> {}
        }*/

}

/**
 * ResultScreen displaying number of photos retrieved.
 */
@Composable
private fun ResultScreen(photos: String, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier

    ) {
        Text(text = photos)
    }
}
