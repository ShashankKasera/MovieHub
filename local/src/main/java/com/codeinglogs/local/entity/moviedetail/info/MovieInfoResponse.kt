package com.codeinglogs.local.entity.moviedetail.info

import androidx.room.Entity
import androidx.room.PrimaryKey
import  com.codeinglogs.data.model.movies.moviedetail.info.MovieInfoResponse as DataMovieInfoResponse

@Entity
data class MovieInfoResponse(
    @PrimaryKey
    val id: Long,
    val backdrop_path: String,
    val budget: Int,
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

fun MovieInfoResponse.toDataMovieInfo(production_companies: List<MovieProductionCompanies>,
                                      genres: List<MovieGener>) =
    DataMovieInfoResponse(
        backdrop_path=backdrop_path,
        budget=budget,
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
        production_companies = production_companies.toDataMovieProductionCompanies(),
        genres = genres.toDataMovieGener()
    )

fun DataMovieInfoResponse.toLocalMovieInfo() = MovieInfoResponse(
        backdrop_path=backdrop_path,
        budget=budget,
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