package com.example.androiddevchallenge.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
//                alignment = Alignment.CenterHorizontally,
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