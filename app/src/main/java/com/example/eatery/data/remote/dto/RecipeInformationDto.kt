package com.example.eatery.data.remote.dto

import com.example.eatery.domain.model.RecipeInformation
import com.google.gson.annotations.SerializedName

data class RecipeInformationDto(
    val aggregateLikes: Int,
    val analyzedInstructions: List<Any>,
    val cheap: Boolean,
    val creditsText: String,
    val cuisines: List<Any>,
    val dairyFree: Boolean,
    val diets: List<Any>,
    val dishTypes: List<String>,
    @SerializedName("extendedIngredients")
    val ingredients: List<Ingredient>,
    val gaps: String,
    val glutenFree: Boolean,
    val healthScore: Double,
    val id: Int,
    val image: String,
    val imageType: String,
    val instructions: String,
    val ketogenic: Boolean,
    val license: String,
    val lowFodmap: Boolean,
    val occasions: List<Any>,
    val pricePerServing: Double,
    val readyInMinutes: Int,
    val servings: Int,
    val sourceName: String,
    val sourceUrl: String,
    val spoonacularScore: Double,
    val spoonacularSourceUrl: String,
    val summary: String,
    val sustainable: Boolean,
    val title: String,
    val vegan: Boolean,
    val vegetarian: Boolean,
    val veryHealthy: Boolean,
    val veryPopular: Boolean,
    val weightWatcherSmartPoints: Int,
    val whole30: Boolean,
    val winePairing: WinePairing
)

fun RecipeInformationDto.toRecipeInformation() : RecipeInformation {
    return RecipeInformation(
        id = id,
        image =  image,
        summary = summary,
        title = title,
        instructions = instructions,
        servings = servings,
        popular = veryPopular,
        ingredients = ingredients,
        readyInMin = readyInMinutes,
        occasions = occasions.map { it as String }
    )
}