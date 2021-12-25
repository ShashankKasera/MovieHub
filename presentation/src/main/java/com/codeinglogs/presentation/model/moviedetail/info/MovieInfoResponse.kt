package com.codeinglogs.presentation.model.moviedetail.info

import com.codeinglogs.domain.model.moviedetail.info.MovieInfoResponse as DomainMovieInfoResponse
import com.codeinglogs.domain.model.moviedetail.info.Gener as domainGener

data class MovieInfoResponse(
    val backdrop_path: String,
    val belongs_to_collection: String,
    val budget: Int,
    val genres: List<Gener>,
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

fun DomainMovieInfoResponse.toPresentationMovieInfoResponse()= MovieInfoResponse(

    backdrop_path=backdrop_path,
    belongs_to_collection=belongs_to_collection,
    budget-budget,
    genres=genres.toPresentationGener(),
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

fun List<domainGener>.toPresentationGener():List<Gener>{
    val list= mutableListOf<Gener>()
    this.forEach { list.add(it.toPresentationGener()) }
    return list
}