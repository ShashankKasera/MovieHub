package com.codeinglogs.presentation.model.moviedetail.similar

import com.codeinglogs.domain.model.moviedetail.similar.MovieSimilar as DomainMovieSimilar
import com.codeinglogs.domain.model.moviedetail.similar.MovieSimilarResponse as domainMovieSimilarResponse

data class MovieSimilarResponse(
    val page: Int,
    val results: List<MovieSimilar>,
    val total_pages: Int,
    val total_results: Int
)

fun domainMovieSimilarResponse.toPresentationMovieReviewsResponse()=MovieSimilarResponse(

        page = page,
        results = results.toPresentationMovieReviews(),
        total_pages = total_pages,
        total_results = total_results
    )

fun List<DomainMovieSimilar>.toPresentationMovieReviews():List<MovieSimilar>{
    val list= mutableListOf<MovieSimilar>()
    this.forEach { list.add(it.toPresentationMovieSimilar()) }
    return list
}