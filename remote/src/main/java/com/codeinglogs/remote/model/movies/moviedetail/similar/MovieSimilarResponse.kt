package com.codeinglogs.remote.model.movies.moviedetail.similar
import com.codeinglogs.remote.model.movies.movieslist.Movies
import com.codeinglogs.remote.model.movies.movieslist.toDataMovies
import com.codeinglogs.data.model.movies.moviedetail.similar.MovieSimilarResponse as DataMovieSimilarResponse

data class MovieSimilarResponse(
    val page: Int?,
    val results: List<Movies>?,
    val total_pages: Int?,
    val total_results: Int?
)

fun MovieSimilarResponse.toDataMovieSimilarResponse()=DataMovieSimilarResponse(
    page=page?:0,
    total_pages=total_pages?:0,
    total_results=total_results?:0,
    results=results?.toDataMovies()?: listOf()
)