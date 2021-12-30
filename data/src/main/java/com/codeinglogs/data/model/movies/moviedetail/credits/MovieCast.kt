package com.codeinglogs.data.model.movies.moviedetail.credits

import com.codeinglogs.domain.model.movies.moviedetail.credits.MovieCast as DomainMovieCast
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
fun MovieCast.toDomainMovieCast()= DomainMovieCast(
    cast_id=cast_id,
    character=character,
    credit_id=credit_id,
    id=id,
    known_for_department=known_for_department,
    name=name,
    original_name=original_name,
    profile_path=profile_path
)