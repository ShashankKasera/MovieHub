package com.codeinglogs.data.model.movies.moviedetail.similar

import com.codeinglogs.domain.model.movies.moviedetail.similar.MovieSimilar as DomainMovieSimilar
import com.codeinglogs.domain.model.movies.moviedetail.similar.MovieSimilarResponse as DomainMovieSimilarResponse

data class MovieSimilarResponse(
    val page: Int,
    val results: List<MovieSimilar>,
    val total_pages: Int,
    val total_results: Int
)

fun MovieSimilarResponse.toDomainMovieReviewsResponse()= DomainMovieSimilarResponse(

        page = page,
        results = results.toDomainMovieReviews(),
        total_pages = total_pages,
        total_results = total_results
    )

fun List<MovieSimilar>.toDomainMovieReviews():List<DomainMovieSimilar>{
    val list= mutableListOf<DomainMovieSimilar>()
    this.forEach { list.add(it.toDomainMovieSimilar()) }
    return list
}