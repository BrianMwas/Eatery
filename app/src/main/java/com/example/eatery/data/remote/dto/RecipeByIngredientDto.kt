package com.example.eatery.data.remote.dto

import com.example.eatery.domain.model.RecipeByIngredient

data class RecipeByIngredientDto(
    val id: Int,
    val image: String,
    val imageType: String,
    val likes: Int,
    val missedIngredientCount: Int,
    val missedIngredients: List<Ingredient>,
    val title: String,
    val unusedIngredients: List<Any>,
    val usedIngredientCount: Int,
    val usedIngredients: List<Ingredient>
)

fun RecipeByIngredientDto.toRecipeByIngredient() : RecipeByIngredient {
    return RecipeByIngredient(
        id = id,
        title = title,
        likes = likes,
        missedIngredients = missedIngredients,
        usedIngredient = usedIngredients,
        image = image
    )
}

fun List<RecipeByIngredientDto>.toRecipeIngredients() : List<RecipeByIngredient> {
    return this.map { it.toRecipeByIngredient() }
}