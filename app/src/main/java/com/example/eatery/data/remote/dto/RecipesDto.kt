package com.example.eatery.data.remote.dto

import com.example.eatery.domain.model.Recipes

data class RecipesDto(
    val calories: Int,
    val carbs: String,
    val fat: String,
    val id: Int,
    val image: String,
    val imageType: String,
    val protein: String,
    val title: String
)

fun RecipesDto.toRecipe() : Recipes {
    return Recipes(
        id = id,
        title = title,
        image = image
    )
}

fun List<RecipesDto>.toRecipes(): List<Recipes> {
    return this.map { it.toRecipe() }
}