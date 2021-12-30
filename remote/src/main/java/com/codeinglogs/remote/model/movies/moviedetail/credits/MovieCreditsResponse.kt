package com.codeinglogs.remote.model.movies.moviedetail.credits

import com.codeinglogs.data.model.movies.moviedetail.credits.MovieCreditsResponse as DataMovieCreditsResponse
import com.codeinglogs.data.model.movies.moviedetail.credits.MovieCast as DataMovieCast
import com.codeinglogs.data.model.movies.moviedetail.credits.MovieCrew as DataMovieCrew

data class MovieCreditsResponse(
    val cast: List<MovieCast>?,
    val crew: List<MovieCrew>?,
    val id: Int?
)

fun MovieCreditsResponse.toDataMovieCreditsResponse()=DataMovieCreditsResponse(
    cast=cast?.toDataCast()?: listOf(),
    crew=crew?.toDataCrew()?: listOf(),
    id=id?:0
)

fun List<MovieCast>.toDataCast():List<DataMovieCast>{
    val list= mutableListOf<DataMovieCast>()
    this.forEach { list.add(it.toDataMovieCast()) }
    return list
}
fun List<MovieCrew>.toDataCrew():List<DataMovieCrew>{
    val list= mutableListOf<DataMovieCrew>()
    this.forEach { list.add(it.toDataMovieCrew()) }
    return list
}

