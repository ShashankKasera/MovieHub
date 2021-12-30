package com.codeinglogs.data.model.movies.moviedetail.similar
import com.codeinglogs.domain.model.movies.moviedetail.similar.MovieSimilar as DomainMovieSimilar

data class MovieSimilar(
    val id: Int,
    val original_title: String,
    val release_date: String,
    val poster_path: String,
    val title: String,
    val vote_average: Double,
)

fun MovieSimilar.toDomainMovieSimilar()= DomainMovieSimilar(
    id=id,
    release_date=release_date,
    original_title=original_title,
    poster_path=poster_path,
    title=title,
    vote_average=vote_average,
)