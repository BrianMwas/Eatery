package com.example.eatery.data.remote

import com.example.eatery.data.remote.dto.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FoodApi {
    @GET("recipes/random")
    suspend fun getRandomRecipes(@Query("number") number: Int?, @Query("tags") tags: String?): List<RecipeInformationDto>

    @GET("recipes/complexSearch")
    suspend fun searchRecipes(
        @Query("diet") diet: String?,
        @Query("equipment") equipment: String?,
        @Query("type") type: String
    ): List<RecipeResultDto>

    @GET("recipes/{id}/information")
    suspend fun getRecipeDetails(@Path("id") id: Int): RecipeInformationDto


    @GET("recipes/{id}/similar")
    suspend fun getSimilarRecipes(@Path("id") id: Int): List<SimilarRecipeDto>

    @GET("recipes/{id}/ingredientWidget.json")
    suspend fun getRecipeIngredients(@Path("id") id: Int);

    // Ingredients search
    @GET("food/ingredients/search")
    suspend fun getIngredientsSearch(
        @Query("query") query: String,
        @Query("minProteinPercent") minProteinPercent: Int,
        @Query("maxProteinPercent") maxProteinPercent: Int,
        @Query("maxFatPercent") maxFatPercent: Int,
        @Query("minFatPercent") minFatPercent: Int,
        @Query("number") num: Int,
        @Query("minCarbsPercent") carbsPercent: Int,
    ): List<RecipeByIngredientDto>

    @GET("recipes/convert")
    suspend fun calcConversion(
        @Query("ingredientName") ingredientName: String,
        @Query("sourceAmount") sourceAmt: Int,
        @Query("sourceUnit") sourceUnit: String,
        @Query("targetUnit") targetUnit: String
    )

    @GET("recipes/findByIngredients")
    suspend fun recipeByIngredients(
        @Query("ingredients") ingredients: String,
        @Query("number") number: String,
        @Query("limitLicense") limitLicense: Int,
        @Query("ranking") ranking: Int,
        @Query("ignorePantry") ignorePantry: Boolean,
    ): List<RecipeByIngredientDto>
}