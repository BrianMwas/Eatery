package com.example.eatery.domain.use_cases.getRecipe

import com.example.eatery.common.Resource
import com.example.eatery.domain.model.RecipeInformation
import com.example.eatery.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetRecipeUseCase @Inject constructor(
    private val repository: RecipeRepository
) {
    operator fun invoke(recipeId: Int) : Flow<Resource<RecipeInformation>> = flow {
        emit(Resource.Loading())
        val recipeDetail = repository.getRecipeDetails(recipeId)

    }
}