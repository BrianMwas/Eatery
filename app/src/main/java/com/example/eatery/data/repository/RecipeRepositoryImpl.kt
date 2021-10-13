package com.example.eatery.data.repository

import com.example.eatery.data.remote.RecipeApi
import com.example.eatery.data.remote.dto.*
import com.example.eatery.domain.model.RecipeByIngredient
import com.example.eatery.domain.model.RecipeInformation
import com.example.eatery.domain.model.Recipes
import com.example.eatery.domain.model.SimilarRecipe
import com.example.eatery.domain.repository.RecipeRepository
import javax.inject.Inject


class RecipeRepositoryImpl @Inject constructor(
    private val recipeApi: RecipeApi
): RecipeRepository {

    override suspend fun getRecipes(num: Int, tags: List<String>?): List<RecipeInformation> {
        return recipeApi.getRandomRecipes(num, tags.toString()).recipes.map { it.toRecipeInformation() }
    }

    override suspend fun getRecipeDetails(id: Int): RecipeInformation {
        return recipeApi.getRecipeDetails(id).toRecipeInformation()
    }

    override suspend fun getSimilarRecipes(recipeId: Int): List<SimilarRecipe> {
        return recipeApi.getSimilarRecipes(recipeId).map { it.toSimilarRecipe() }
    }

    override suspend fun searchRecipe(
        diet: String?,
        equipment: String?,
        type: String?
    ): List<Recipes> {
        return recipeApi.searchRecipes(diet = diet, equipment = equipment, type = type).results.map { it.toRecipe() }
    }

    override suspend fun searchRecipeByIngredient(ingredient: String, number: String?, limitLicense: Int?, ranking: Int?, ignorePantry: Boolean?): List<RecipeByIngredient> {
        return recipeApi.recipeByIngredients(ingredients = ingredient, number = number, limitLicense = limitLicense, ranking = ranking, ignorePantry = ignorePantry).toRecipeIngredients()
    }

    override suspend fun getRecipeBYIngredient(
        searchTerm: String,
        num: Int,
        minProteinPercent: Int?,
        maxProteinPercent: Int?,
        maxFatPercent: Int?,
        minFatPercent: Int?,
        carbsPresent: Int?
    ): List<RecipeByIngredient> {
        return recipeApi.getIngredientsSearch(
            query = searchTerm,
            num = num,
            maxFatPercent = maxFatPercent,
            minFatPercent = minFatPercent,
            maxProteinPercent = maxProteinPercent,
            minProteinPercent = minProteinPercent,
            carbsPercent = carbsPresent
        ).map { it.toRecipeByIngredient() }
    }
}