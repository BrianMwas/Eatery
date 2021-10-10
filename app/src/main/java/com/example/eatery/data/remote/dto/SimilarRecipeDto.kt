package com.example.eatery.data.remote.dto

import com.example.eatery.domain.model.SimilarRecipe

data class SimilarRecipeDto(
    val id: Int,
    val imageType: String,
    val readyInMinutes: Int,
    val servings: Int,
    val sourceUrl: String,
    val title: String
)

fun SimilarRecipeDto.toSimilarRecipe(): SimilarRecipe {
    return SimilarRecipe(
        id = id,
        readyInMin = readyInMinutes,
        sourceUrl = sourceUrl,
        title = title
    )
}