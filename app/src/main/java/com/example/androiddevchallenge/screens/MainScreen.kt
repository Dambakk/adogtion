package com.example.androiddevchallenge.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.components.DogCard
import com.example.androiddevchallenge.data.Data
import com.example.androiddevchallenge.data.DogModel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainListScreen(modifier: Modifier = Modifier) {

    val dogs = remember { Data.dogImages.map { DogModel(name = Data.names.random(), imgUrl = it) } }

    // TODO: Figure out grid instead:
    // LazyVerticalGrid(cells = GridCells.Fixed(2)) {
    LazyColumn(modifier = modifier) {
        item {
            DogListHeader()
        }
        items(dogs) { dog ->
            DogCard(dog = dog, modifier = Modifier.fillMaxWidth())
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
