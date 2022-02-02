package com.codeinglogs.presentation.model.movies.moviedetail.reviews

import com.codeinglogs.domain.model.movies.moviedetail.reviews.MovieReviewsResponse as DomainMovieReviewsResponse
import com.codeinglogs.domain.model.movies.moviedetail.reviews.MovieReviews as DomainMovieReviews

data class MovieReviewsResponse(
    val id: Int,
    val results: List<MovieReviews>,

)

fun DomainMovieReviewsResponse.toPresentationMovieReviewsResponse()=MovieReviewsResponse(
        id = id,
        results = results.toDomainMovieReviews(),
    )

fun List<DomainMovieReviews>.toDomainMovieReviews():List<MovieReviews> {
    val list = mutableListOf<MovieReviews>()
    this.forEach { list.add(it.toPresentationMovieReviews()) }
    return list
}