package com.codeinglogs.domain.model.movies.moviedetail.similar

import com.codeinglogs.domain.model.movies.movieslist.Movies


data class MovieSimilarResponse(
    val page: Int,
    val results: List<Movies>,
    val total_pages: Int,
    val total_results: Int
)