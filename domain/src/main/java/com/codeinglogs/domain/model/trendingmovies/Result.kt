package com.codeinglogs.domain.model.trendingmovies

data class Result(
    val id: Double,
    val original_language: String,
    val original_name: String,
    val original_title: String,
    val poster_path: String,
    val title: String,
)