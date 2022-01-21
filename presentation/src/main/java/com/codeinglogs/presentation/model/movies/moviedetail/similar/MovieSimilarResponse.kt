package com.codeinglogs.presentation.model.movies.moviedetail.similar

import com.codeinglogs.presentation.model.movies.movieslist.Movies
import com.codeinglogs.presentation.model.movies.movieslist.toPresentationMovies
import com.codeinglogs.domain.model.movies.moviedetail.similar.MovieSimilarResponse as domainMovieSimilarResponse

data class MovieSimilarResponse(
    val page: Int,
    val results: List<Movies>,
    val total_pages: Int,
    val total_results: Int
)

fun domainMovieSimilarResponse.toPresentationMovieReviewsResponse()=MovieSimilarResponse(

        page = page,
        results = results.toPresentationMovies(),
        total_pages = total_pages,
        total_results = total_results
)