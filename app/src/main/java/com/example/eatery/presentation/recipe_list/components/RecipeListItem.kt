package com.example.eatery.presentation.recipe_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberImagePainter
import com.example.eatery.domain.model.RecipeInformation

@ExperimentalMaterialApi
@Composable
fun RecipeListItem(
    recipeInformation: RecipeInformation,
    onRecipeClick: (RecipeInformation) -> Unit
) {
    Card(
        elevation = 1.dp,
        shape = MaterialTheme.shapes.small,
        backgroundColor = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp),
        onClick = { onRecipeClick(recipeInformation) }
    ) {
            Column {
                Image(
                    painter = rememberImagePainter(
                        data = "https://source.unsplash.com/random/food",
                        imageLoader = ImageLoader.Builder(LocalContext.current)
                            .crossfade(true)
                            .crossfade(1200)
                            .build(),
                        builder = {
                            crossfade(true)
                        }
                    ),
                    contentDescription = recipeInformation.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                )
                Text(
                    text = recipeInformation.title,
                    style = MaterialTheme.typography.h6,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 4.dp)
                )
                Spacer(modifier = Modifier.padding(vertical = 2.dp))
                Text(
                    text = "Ready in ${recipeInformation.readyInMin} Min",
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
            }
    }
}
