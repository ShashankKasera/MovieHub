package com.codeinglogs.presentation.model.movies.moviedetail.info

import com.codeinglogs.domain.model.movies.moviedetail.info.MovieInfoResponse as DomainMovieInfoResponse
import com.codeinglogs.domain.model.movies.moviedetail.info.MovieGener as domainMovieGener
import com.codeinglogs.domain.model.movies.moviedetail.info.MovieProductionCompanies as domainProductionCompanies

data class MovieInfoResponse(
    val backdrop_path: String,
    val budget: Int,
    val production_companies: List<MovieProductionCompanies>,
    val genres: List<MovieGener>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val status: String,
    val title: String,
    val vote_average: Double,
)

fun DomainMovieInfoResponse.toPresentationMovieInfoResponse()= MovieInfoResponse(

    production_companies=production_companies.toPresentationProductionCompanies(),
    backdrop_path=backdrop_path,
    budget=budget,
    genres=genres.toPresentationGener(),
    id=id,
    original_language=original_language,
    original_title=original_title,
    overview=overview,
    poster_path=poster_path,
    release_date=release_date,
    revenue=revenue,
    runtime=runtime,
    status=status,
    title=title,
    vote_average=vote_average,
)

fun List<domainMovieGener>.toPresentationGener():List<MovieGener>{
    val list= mutableListOf<MovieGener>()
    this.forEach { list.add(it.toPresentationMovieGener()) }
    return list
}

fun List<domainProductionCompanies>.toPresentationProductionCompanies():List<MovieProductionCompanies>{
    val list= mutableListOf<MovieProductionCompanies>()
    this.forEach { list.add(it.toPresentationMovieProductionCompanies()) }
    return list
}