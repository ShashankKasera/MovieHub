package com.codeinglogs.data.model.movies.moviedetail.info
import com.codeinglogs.domain.model.movies.moviedetail.info.MovieProductionCompanies as DomainMovieProductionCompanies

data class MovieProductionCompanies (
    val id: Long,
    val name: String
)

fun MovieProductionCompanies.toDomainMovieProductionCompanies()=DomainMovieProductionCompanies(
    id=id,
    name=name
)