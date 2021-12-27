package com.codeinglogs.remote.model.moviedetail.similar
import com.codeinglogs.data.model.moviedetail.similar.MovieSimilarResponse as DataMovieSimilarResponse
import com.codeinglogs.data.model.moviedetail.similar.MovieSimilar as DataMovieSimilar

data class MovieSimilarResponse(
    val page: Int?,
    val results: List<MovieSimilar>?,
    val total_pages: Int?,
    val total_results: Int?
)

fun MovieSimilarResponse.toDataMovieSimilarResponse()=DataMovieSimilarResponse(
    page=page?:0,
    total_pages=total_pages?:0,
    total_results=total_results?:0,
    results=results?.toDataMovieSimilar()?: listOf()
)

fun List<MovieSimilar>.toDataMovieSimilar():List<DataMovieSimilar>{
    val list= mutableListOf<DataMovieSimilar>()
    this.forEach { list.add(it.toDataMovieSimilar()) }
    return list
}


