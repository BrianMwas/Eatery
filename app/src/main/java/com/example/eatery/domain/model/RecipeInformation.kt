package com.example.eatery.domain.model

import com.example.eatery.data.remote.dto.Ingredient
import com.example.eatery.data.remote.dto.RecipeInformationDto

data class RecipeInformation(
    val ingredients: List<Ingredient>,
    val id: Int,
    val image: String,
    val instructions: String,
    val readyInMin: Int,
    val servings: Int,
    val summary: String,
    val title: String,
    val popular: Boolean,
    val occasions: List<String>
)

