package com.example.eatery.domain.repository

import com.example.eatery.data.remote.dto.RecipeInformationDto
import com.example.eatery.data.remote.dto.RecipesDto
import com.example.eatery.data.remote.dto.SimilarRecipeDto
import com.example.eatery.domain.model.RecipeByIngredient
import com.example.eatery.domain.model.RecipeInformation
import com.example.eatery.domain.model.Recipes
import com.example.eatery.domain.model.SimilarRecipe

interface RecipeRepository {
    suspend fun getRecipes(num: Int, tags: List<String>? = null): List<RecipeInformation>
    suspend fun getRecipeDetails(id: Int): RecipeInformation
    suspend fun getSimilarRecipes(recipeId: Int): List<SimilarRecipe>;
    suspend fun searchRecipe(
        diet: String?,
        equipment: String?,
        type: String?
    ): List<Recipes>
    suspend fun searchRecipeByIngredient(ingredient: String, number: String?, limitLicense: Int?, ranking: Int?, ignorePantry: Boolean?): List<RecipeByIngredient>
}