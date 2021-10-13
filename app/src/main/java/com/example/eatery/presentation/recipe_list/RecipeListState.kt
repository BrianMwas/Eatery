package com.example.eatery.presentation.recipe_list

import com.example.eatery.domain.model.RecipeInformation

data class RecipeListState(
    val isLoading: Boolean = false,
    val recipes: List<RecipeInformation> = emptyList(),
     val error: String = "",
)
