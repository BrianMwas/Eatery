package com.example.eatery.domain.model

data class SimilarRecipe(
    val id: Int,
    val readyInMin: Int,
    val sourceUrl: String,
    val title: String,
)
