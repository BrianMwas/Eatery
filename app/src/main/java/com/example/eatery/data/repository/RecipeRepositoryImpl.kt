package com.example.eatery.data.repository

import com.example.eatery.data.remote.RecipeApi
import com.example.eatery.data.remote.dto.RecipeInformationDto
import com.example.eatery.data.remote.dto.toRecipe
import com.example.eatery.data.remote.dto.toRecipeInformation
import com.example.eatery.data.remote.dto.toSimilarRecipe
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
        return recipeApi.getRandomRecipes(num, tags).map { it.recipes.toRecipes() }
    }

    override suspend fun getRecipeDetails(id: Int): RecipeInformationDto {
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
        return recipeApi.recipeByIngredients(ingredients = ingredient, number = number, limitLicense, ranking, ignorePantry).map { it.toRecipeByIngredient() }
    }
}