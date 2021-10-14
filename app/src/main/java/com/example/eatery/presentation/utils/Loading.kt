package com.example.eatery.presentation.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.eatery.R

@Composable
fun Loading() {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.loader))
    val progress by animateLottieCompositionAsState(composition = composition)
    LottieAnimation(composition = composition, progress = progress)
}