package com.example.eatery.presentation.recipe_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eatery.common.Resource
import com.example.eatery.domain.use_cases.getRecipes.GetRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val getRecipesUseCase: GetRecipesUseCase
) : ViewModel() {
    private val _state = mutableStateOf(RecipeListState())
    val state : State<RecipeListState> = _state

    init {
        getRecipes()
    }

    private fun getRecipes() {
        getRecipesUseCase(num = 15).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = RecipeListState(recipes = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _state.value = RecipeListState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = RecipeListState(error = result.message ?: "An unexpected error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }
}