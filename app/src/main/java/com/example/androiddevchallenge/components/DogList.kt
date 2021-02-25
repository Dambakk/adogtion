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
package com.example.androiddevchallenge.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.transform.CircleCropTransformation
import com.example.androiddevchallenge.data.Data
import com.example.androiddevchallenge.data.DogModel
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
@Preview(showBackground = true)
fun DogPreview() {
    DogCard(
        dog = DogModel(
            name = "Fido",
            imgUrl = Data.dogImages.first(),
        )
    )
}

@Composable
fun DogCard(dog: DogModel, modifier: Modifier = Modifier, onDogClicked: (DogModel) -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .clickable { onDogClicked(dog) }
            .then(modifier)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CoilImage(
                data = dog.imgUrl,
                contentDescription = "Dog image",
                modifier = Modifier.size(60.dp),
                fadeIn = true,
                requestBuilder = {
                    transformations(CircleCropTransformation())
                },
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = dog.name,
                style = MaterialTheme.typography.h4
            )
        }
    }
}
