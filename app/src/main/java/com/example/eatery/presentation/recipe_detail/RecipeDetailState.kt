package com.example.eatery.presentation.recipe_detail

import com.example.eatery.domain.model.RecipeInformation

data class RecipeDetailState(
    val isLoading: Boolean = false,
    val recipeDetail: RecipeInformation? = null,
    val error: String = ""
)