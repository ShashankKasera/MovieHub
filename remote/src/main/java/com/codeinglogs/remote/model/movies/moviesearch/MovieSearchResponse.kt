package com.codeinglogs.remote.model.movies.moviesearch

import com.codeinglogs.remote.model.movies.movieslist.Movies


data class MovieSearchResponse(
    val page: Int?,
    val results: List<Movies>?,
    val total_pages: Int?,
    val total_results: Int?
)
