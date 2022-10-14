package com.codeinglogs.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.codeinglogs.data.model.movies.movieslist.Movies as DataMovies

@Entity
data class Movies (
    @PrimaryKey
    val id: Long,
    val movieId: Long,
    val original_title: String,
    val original_name: String,
    val poster_path: String,
    val backdrop_path: String,
    val release_date: String,
    val vote_average: Double,
)

fun Movies.toDataMovies() = DataMovies(
    id = movieId ,
    title = original_name ?: original_title,
    poster_path = poster_path,
    backdrop_path = backdrop_path,
    release_date = release_date,
    vote_average = vote_average
)

fun List<Movies>.toDataMovies() : List<DataMovies>{
    val list = mutableListOf<DataMovies>()
    this.forEach { list.add(it.toDataMovies()) }
    return list
}

fun DataMovies.toLocalMovies() = Movies(
    id = id ,
    movieId = id,
    original_name = title,
    original_title = title,
    poster_path = poster_path,
    backdrop_path = backdrop_path,
    release_date = release_date,
    vote_average = vote_average
)

fun List<DataMovies>.toLocalMovies() : List<Movies>{
    val list = mutableListOf<Movies>()
    this.forEach { list.add(it.toLocalMovies()) }
    return list
}