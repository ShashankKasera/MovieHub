package com.codeinglogs.local.entity.moviedetail.info

import androidx.room.Entity
import androidx.room.PrimaryKey

import com.codeinglogs.data.model.movies.moviedetail.info.MovieProductionCompanies as DataMovieProductionCompanies

@Entity
data class MovieProductionCompanies(
    @PrimaryKey
    val id:Long,
    val name: String
)

fun MovieProductionCompanies.toDataMovieProductionCompanies() =
    DataMovieProductionCompanies(
        id=id,
        name = name
    )

fun List<MovieProductionCompanies>.toDataMovieProductionCompanies() : List<DataMovieProductionCompanies>{
    val list = mutableListOf<DataMovieProductionCompanies>()
    this.forEach { list.add(it.toDataMovieProductionCompanies()) }
    return list
}

fun DataMovieProductionCompanies.toLocalMovieProductionCompanies() = MovieProductionCompanies(
    id=id,
    name = name
)

fun List<DataMovieProductionCompanies>.toLocalMovieProductionCompanies() : List<MovieProductionCompanies>{
    val list = mutableListOf<MovieProductionCompanies>()
    this.forEach { list.add(it.toLocalMovieProductionCompanies()) }
    return list
}