package com.example.eatery.presentation.recipe_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eatery.common.Constants
import com.example.eatery.common.Resource
import com.example.eatery.domain.use_cases.getRecipe.GetRecipeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val getRecipeUseCase: GetRecipeUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(RecipeDetailState())
    val state: State<RecipeDetailState> = _state

    init {
        savedStateHandle.get<Int>(Constants.PARAM_RECIPE_ID)?.let { recipeId ->
            getRecipeDetail(recipeId)
        }
    }

    private fun getRecipeDetail(recipeId: Int) {
        getRecipeUseCase(recipeId).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = RecipeDetailState(recipeDetail = result.data)
                }
                is Resource.Error -> {
                    _state.value = RecipeDetailState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = RecipeDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}