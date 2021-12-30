package com.codeinglogs.domain.model.movies.moviedetail.credits

data class MovieCast(

    val cast_id: Int,
    val character: String,
    val credit_id: String,
    val id: Int,
    val known_for_department: String,
    val name: String,
    val original_name: String,
    val profile_path: String
)