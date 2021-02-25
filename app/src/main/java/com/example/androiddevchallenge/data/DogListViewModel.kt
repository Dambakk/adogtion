package com.example.androiddevchallenge.data

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class DogListViewModel  : ViewModel() {

    val dogs = MutableStateFlow(
        Data.dogImages.map { DogModel(name = "Fido", imgUrl = it) }
    )

}