package com.example.androiddevchallenge.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.DogModel
import dev.chrisbanes.accompanist.coil.CoilImage

@Preview(showBackground = true)
@Composable
fun DogDetailsPreview() {
    DogDetailsScreen(dog = DogModel(name = "Fido", imgUrl = ""), onCloseClicked = {})
}

@Composable
fun DogDetailsScreen(dog: DogModel, modifier: Modifier = Modifier, onCloseClicked: () -> Unit) {

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .then(modifier)
    ) {
        Surface(
            elevation = 1.dp,
        ) {
            CoilImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                data = dog.imgUrl,
                contentDescription = dog.name,
                fadeIn = true,
                contentScale = ContentScale.FillWidth,
            )

            Surface(
                shape = CircleShape,
                color = MaterialTheme.colors.surface.copy(alpha = 0.7f),
                modifier = Modifier
                    .padding(start = 24.dp, top = 16.dp)
                    .clip(CircleShape)
                    .clipToBounds()
                    .wrapContentSize()
                    .clickable { onCloseClicked() },
            ) {
                Text(
                    text = "X",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h5.copy(
                        fontWeight = FontWeight.Bold,
                        lineHeight = 40.sp,
                    ),
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        }

        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
            Spacer(Modifier.height(16.dp))
            Text(
                text = dog.name,
                style = MaterialTheme.typography.h4.copy(
                    fontWeight = FontWeight.Bold,
                ),
            )

            Spacer(Modifier.height(16.dp))
            Text(text = "${dog.name} is a good dogger, the best of doggers.")

        }


    }

}