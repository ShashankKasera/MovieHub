package com.codeinglogs.presentation.model.moviedetail.similar
import com.codeinglogs.domain.model.moviedetail.similar.MovieSimilar as DomainMovieSimilar

data class MovieSimilar(
    val id: Int,
    val original_title: String,
    val poster_path: String,
    val title: String,
    val vote_average: Double,
)

fun DomainMovieSimilar.toPresentationMovieSimilar()=MovieSimilar(
        id = id,
        original_title = original_title,
        poster_path = poster_path,
        title = title,
        vote_average = vote_average,
    )