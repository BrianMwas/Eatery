package com.example.eatery.data.remote.dto

data class RecipeResultDto(
    val number: Int,
    val offset: Int,
    val results: List<RecipesDto>,
    val totalResults: Int
)