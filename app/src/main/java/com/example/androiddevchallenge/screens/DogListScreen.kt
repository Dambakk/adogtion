/*
 * Copyright 2021 The Android Open Source Project
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
package com.example.androiddevchallenge.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.components.DogCard
import com.example.androiddevchallenge.data.DogModel

@Composable
fun MainListScreen(
    dogs: List<DogModel>,
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
    onDogClicked: (DogModel) -> Unit,
) {

    // TODO: Figure out grid instead:
    // LazyVerticalGrid(cells = GridCells.Fixed(2)) {
    LazyColumn(
        modifier = modifier,
        state = state
    ) {
        item {
            DogListHeader()
        }
        items(dogs) { dog ->
            DogCard(
                dog = dog,
                modifier = Modifier.fillMaxWidth(),
                onDogClicked = onDogClicked,
            )
        }
    }
}

@Composable
fun DogListHeader() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(38.dp))
        Text(
            text = "Dogs available for adoption",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.Bold),
        )
        Spacer(modifier = Modifier.height(24.dp))
    }
}
