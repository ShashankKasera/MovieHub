package com.codeinglogs.data.model.movies.moviedetail.similar

import com.codeinglogs.data.model.movies.movieslist.Movies
import com.codeinglogs.data.model.movies.movieslist.toDomainMovies
import com.codeinglogs.domain.model.movies.moviedetail.similar.MovieSimilarResponse as DomainMovieSimilarResponse

data class MovieSimilarResponse(
    val page: Int,
    val results: List<Movies>,
    val total_pages: Int,
    val total_results: Int
)

fun MovieSimilarResponse.toDomainMovieReviewsResponse()= DomainMovieSimilarResponse(

        page = page,
        results = results.toDomainMovies(),
        total_pages = total_pages,
        total_results = total_results
)