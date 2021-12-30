package com.codeinglogs.domain.model.movies.moviedetail.credits

data class MovieCrew(

    val credit_id: String,
    val department: String,
    val id: Int,
    val known_for_department: String,
    val name: String,
    val original_name: String,
    val profile_path: String
)

