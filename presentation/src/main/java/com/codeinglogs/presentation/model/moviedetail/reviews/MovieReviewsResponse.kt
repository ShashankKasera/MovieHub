package com.codeinglogs.presentation.model.moviedetail.reviews

import com.codeinglogs.domain.model.moviedetail.reviews.MovieReviewsResponse as DomainMovieReviewsResponse
import com.codeinglogs.domain.model.moviedetail.reviews.MovieReviews as DomainMovieReviews

data class MovieReviewsResponse(
    val id: Int,
    val page: Int,
    val results: List<MovieReviews>,
    val total_pages: Int,
    val total_results: Int
)

fun DomainMovieReviewsResponse.toPresentationMovieReviewsResponse()=MovieReviewsResponse(
        id = id,
        page = page,
        results = results.toDomainMovieReviews(),
        total_pages = total_pages,
        total_results = total_results
    )

fun List<DomainMovieReviews>.toDomainMovieReviews():List<MovieReviews> {
    val list = mutableListOf<MovieReviews>()
    this.forEach { list.add(it.toPresentationMovieReviews()) }
    return list
}