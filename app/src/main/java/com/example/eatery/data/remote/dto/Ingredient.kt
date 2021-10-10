package com.example.eatery.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Ingredient(
    val aisle: String,
    val amount: Double,
    @SerializedName("consitency")
    val consistency: String,
    val id: Int,
    val image: String,
    val measures: Measures,
    val meta: List<String>,
    val name: String,
    val original: String,
    val originalName: String,
    val unit: String
)