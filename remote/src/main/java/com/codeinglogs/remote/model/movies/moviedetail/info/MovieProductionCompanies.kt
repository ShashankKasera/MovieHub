package com.codeinglogs.remote.model.movies.moviedetail.info
import com.codeinglogs.data.model.movies.moviedetail.info.MovieProductionCompanies as DataMovieProductionCompanies

data class MovieProductionCompanies (
    val name: String?
)

fun MovieProductionCompanies.toDataMovieProductionCompanies()=DataMovieProductionCompanies(
    name=name?:""
)