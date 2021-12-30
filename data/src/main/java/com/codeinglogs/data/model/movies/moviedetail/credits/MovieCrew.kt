package com.codeinglogs.data.model.movies.moviedetail.credits

import com.codeinglogs.domain.model.movies.moviedetail.credits.MovieCrew as DomainMovieCrew
data class MovieCrew(

    val credit_id: String,
    val department: String,
    val id: Int,
    val known_for_department: String,
    val name: String,
    val original_name: String,
    val profile_path: String
)

fun MovieCrew.toDomainMovieCrew()= DomainMovieCrew(
    credit_id=credit_id,
    department=department,
    id=id,
    known_for_department=known_for_department,
    name=name,
    original_name=original_name,
    profile_path=profile_path
)