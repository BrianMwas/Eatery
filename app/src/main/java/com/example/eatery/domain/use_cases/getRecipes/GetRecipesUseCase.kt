package com.example.eatery.domain.use_cases.getRecipes

import com.example.eatery.common.Resource
import com.example.eatery.domain.model.RecipeInformation
import com.example.eatery.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetRecipesUseCase @Inject constructor(
    private val repository: RecipeRepository
) {
    operator fun invoke(num: Int): Flow<Resource<List<RecipeInformation>>> = flow {
        try {
            emit(Resource.Loading())
            val recipes = repository.getRecipes(num)
            emit(Resource.Success(recipes))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("An error occurred we could not reach servers. Please check internet connection"))
        }
    }
}