package com.codeinglogs.remote.model.movies.moviedetail.reviews

import com.codeinglogs.data.model.movies.moviedetail.reviews.MovieReviewsResponse as DataMovieReviewsResponse
import com.codeinglogs.data.model.movies.moviedetail.reviews.MovieReviews as DataMovieReviews

data class MovieReviewsResponse(
    val id: Int?,
    val page: Int?,
    val results: List<MovieReviews>?,
    val total_pages: Int?,
    val total_results: Int?
)

fun MovieReviewsResponse.toDataMovieReviewsResponse()=DataMovieReviewsResponse(
    id=id?:0,
    page=page?:0,
    results=results?.toDataMovieReviews()?: listOf(),
    total_pages=total_pages?:0,
    total_results=total_results?:0
)

fun List<MovieReviews>.toDataMovieReviews():List<DataMovieReviews>{
    val list= mutableListOf<DataMovieReviews>()
    this.forEach { list.add(it.toDataMovieReviews()) }
    return list
}