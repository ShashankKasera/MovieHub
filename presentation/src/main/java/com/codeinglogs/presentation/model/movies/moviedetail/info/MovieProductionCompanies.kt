package com.codeinglogs.presentation.model.movies.moviedetail.info
import com.codeinglogs.domain.model.movies.moviedetail.info.MovieProductionCompanies as DomainMovieProductionCompanies

data class MovieProductionCompanies (
    val name: String?
)

fun DomainMovieProductionCompanies.toPresentationMovieProductionCompanies()=MovieProductionCompanies(
    name=name
)