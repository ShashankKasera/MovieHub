package com.codeinglogs.data.model.moviedetail.reviews

import com.codeinglogs.domain.model.moviedetail.reviews.MovieReviewsResponse as DomainMovieReviewsResponse
import com.codeinglogs.domain.model.moviedetail.reviews.MovieReviews as DomainMovieReviews

data class MovieReviewsResponse(
    val id: Int,
    val page: Int,
    val results: List<MovieReviews>,
    val total_pages: Int,
    val total_results: Int
)

fun MovieReviewsResponse.toDomainMovieReviewsResponse()= DomainMovieReviewsResponse(
    id=id,
    page=page,
    results=results.toDomainMovieReviews(),
    total_pages=total_pages,
    total_results=total_results
)

fun List<MovieReviews>.toDomainMovieReviews():List<DomainMovieReviews>{
    val list= mutableListOf<DomainMovieReviews>()
    this.forEach { list.add(it.toDomainMovieReviews()) }
    return list
}