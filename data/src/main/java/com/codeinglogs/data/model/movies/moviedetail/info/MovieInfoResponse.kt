package com.codeinglogs.data.model.movies.moviedetail.info

import com.codeinglogs.domain.model.movies.moviedetail.info.MovieInfoResponse as DomainMovieInfoResponse
import com.codeinglogs.domain.model.movies.moviedetail.info.MovieGener as DomainMovieGener
import com.codeinglogs.domain.model.movies.moviedetail.info.MovieProductionCompanies as DomainMovieProductionCompanies
data class MovieInfoResponse(
    val backdrop_path: String,
    val belongs_to_collection: String,
    val budget: Int,
    val production_companies: List<MovieProductionCompanies>,
    val genres: List<MovieGener>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)

fun MovieInfoResponse.toDomainMovieInfoResponse()=DomainMovieInfoResponse(
    production_companies=production_companies.toDomainProductionCompanies(),
    backdrop_path=backdrop_path,
    belongs_to_collection=belongs_to_collection,
    budget=budget,
    genres=genres.toDomainGener(),
    homepage=homepage,
    id=id,
    imdb_id=imdb_id,
    original_language=original_language,
    original_title=original_title,
    overview=overview,
    popularity=popularity,
    poster_path=poster_path,
    release_date=release_date,
    revenue=revenue,
    runtime=runtime,
    status=status,
    tagline=tagline,
    title=title,
    video=video,
    vote_average=vote_average,
    vote_count=vote_count
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