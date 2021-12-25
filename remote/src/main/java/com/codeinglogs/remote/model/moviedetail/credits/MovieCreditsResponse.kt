package com.codeinglogs.remote.model.moviedetail.credits

import com.codeinglogs.data.model.moviedetail.credits.MovieCreditsResponse as DataMovieCreditsResponse
import com.codeinglogs.data.model.moviedetail.credits.Cast as DataCast
import com.codeinglogs.data.model.moviedetail.credits.Crew as DataCrew

data class MovieCreditsResponse(
    val cast: List<Cast>?,
    val crew: List<Crew>?,
    val id: Int?
)

fun MovieCreditsResponse.toDataMovieCreditsResponse()=DataMovieCreditsResponse(
    cast=cast?.toDataCast()?: listOf(),
    crew=crew?.toDataCrew()?: listOf(),
    id=id?:0
)

fun List<Cast>.toDataCast():List<DataCast>{
    val list= mutableListOf<DataCast>()
    this.forEach { list.add(it.toDataCast()) }
    return list
}
fun List<Crew>.toDataCrew():List<DataCrew>{
    val list= mutableListOf<DataCrew>()
    this.forEach { list.add(it.toDataCrew()) }
    return list
}

