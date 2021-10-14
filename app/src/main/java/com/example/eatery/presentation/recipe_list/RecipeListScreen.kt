package com.example.eatery.presentation.recipe_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BusAlert
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.eatery.presentation.Screen
import com.example.eatery.presentation.recipe_list.components.RecipeListItem

@ExperimentalMaterialApi
@Composable
fun RecipeListScreen(
    navController: NavController,
    viewModel: RecipeListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.recipes) { recipe ->
                RecipeListItem(recipeInformation = recipe, onRecipeClick = {
                    navController.navigate(Screen.RecipeDetailScreen.route + "/${recipe.id}")
                })
            }
        }
        if(state.error.isNotBlank()) {
            Column(modifier = Modifier.align(Alignment.Center)) {
                Icon(Icons.Filled.Error, "Error: ${state.error}")
                Spacer(modifier =  Modifier.height(5.dp))
                Text(
                    text = state.error,
                    textAlign = TextAlign.Center
                )
            }
        }
        if(state.isLoading) {

        }
    }
}