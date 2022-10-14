package com.codeinglogs.data.model.movies.moviedetail.info

import com.codeinglogs.domain.model.movies.moviedetail.info.MovieInfoResponse as DomainMovieInfoResponse
import com.codeinglogs.domain.model.movies.moviedetail.info.MovieGener as DomainMovieGener
import com.codeinglogs.domain.model.movies.moviedetail.info.MovieProductionCompanies as DomainMovieProductionCompanies
data class MovieInfoResponse(
    val backdrop_path: String,
    val budget: Int,
    val production_companies: List<MovieProductionCompanies>,
    val genres: List<MovieGener>,
    val id: Long,
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

fun MovieInfoResponse.toDomainMovieInfoResponse()=DomainMovieInfoResponse(
    production_companies=production_companies.toDomainProductionCompanies(),
    backdrop_path=backdrop_path,
    budget=budget,
    genres=genres.toDomainGener(),
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

fun List<MovieGener>.toDomainGener():List<DomainMovieGener>{
    val list= mutableListOf<DomainMovieGener>()
    this.forEach { list.add(it.toDomainMovieGener()) }
    return list
}

fun List<MovieProductionCompanies>.toDomainProductionCompanies():List<DomainMovieProductionCompanies>{
    val list= mutableListOf<DomainMovieProductionCompanies>()
    this.forEach { list.add(it.toDomainMovieProductionCompanies()) }
    return list
}