package com.example.eatery.domain.model

import com.example.eatery.data.remote.dto.Ingredient

data class RecipeByIngredient(
    val id: Int,
    val image: String,
    val likes: Int,
    val missedIngredients: List<Ingredient>,
    val title: String,
    val usedIngredient: List<Ingredient>
)
