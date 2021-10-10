package com.example.eatery.data.remote.dto

data class WinePairing(
    val pairedWines: List<String>,
    val pairingText: String,
    val productMatches: List<ProductMatch>
)