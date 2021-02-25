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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.data.Data
import com.example.androiddevchallenge.data.DogModel
import com.example.androiddevchallenge.screens.DogDetailsScreen
import com.example.androiddevchallenge.screens.MainListScreen
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

sealed class Screen {
    object DogList : Screen()
    data class DogDetails(val dog: DogModel) : Screen()
}

// Start building your app here!
@Composable
fun MyApp() {
    Surface(
        color = MaterialTheme.colors.background
    ) {

        val currentScreen: MutableState<Screen> = remember { mutableStateOf(Screen.DogList) }
        val dogs = remember {
            Data.dogImages.shuffled().zip(Data.names.shuffled()) { img, name ->
                DogModel(name = name, imgUrl = img)
            }
        }
        val scrollState = rememberLazyListState()


        Crossfade(targetState = currentScreen.value) { screen ->
            when (screen) {
                Screen.DogList -> MainListScreen(
                    dogs = dogs,
                    state = scrollState,
                    modifier = Modifier.fillMaxSize()
                ) {
                    currentScreen.value = Screen.DogDetails(it)
                }
                is Screen.DogDetails -> DogDetailsScreen(dog = screen.dog) {
                    currentScreen.value = Screen.DogList
                }
            }
        }

    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
