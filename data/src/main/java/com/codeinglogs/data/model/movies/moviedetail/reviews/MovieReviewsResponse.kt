package com.codeinglogs.data.model.movies.moviedetail.reviews

import com.codeinglogs.domain.model.movies.moviedetail.reviews.MovieReviewsResponse as DomainMovieReviewsResponse
import com.codeinglogs.domain.model.movies.moviedetail.reviews.MovieReviews as DomainMovieReviews

data class MovieReviewsResponse(
    val id: Int,
    val results: List<MovieReviews>,
)

fun MovieReviewsResponse.toDomainMovieReviewsResponse()= DomainMovieReviewsResponse(
    id=id,
    results=results.toDomainMovieReviews(),
)

fun List<MovieReviews>.toDomainMovieReviews():List<DomainMovieReviews>{
    val list= mutableListOf<DomainMovieReviews>()
    this.forEach { list.add(it.toDomainMovieReviews()) }
    return list
}