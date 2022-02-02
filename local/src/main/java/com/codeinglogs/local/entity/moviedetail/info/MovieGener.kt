package com.codeinglogs.local.entity.moviedetail.info

import androidx.room.Entity
import androidx.room.PrimaryKey

import com.codeinglogs.data.model.movies.moviedetail.info.MovieGener as DataMovieGener
@Entity
data class MovieGener(
    @PrimaryKey
    val id: Int,
    val name: String,
)

fun MovieGener.toDataMovieGener() =
    DataMovieGener(
        id = id,
        name = name
    )

fun List<MovieGener>.toDataMovieGener() : List<DataMovieGener>{
    val list = mutableListOf<DataMovieGener>()
    this.forEach { list.add(it.toDataMovieGener()) }
    return list
}

fun DataMovieGener.toLocalMovieGener() = MovieGener(
    id = id,
    name = name
)

fun List<DataMovieGener>.toLocalMovieGener() : List<MovieGener>{
    val list = mutableListOf<MovieGener>()
    this.forEach { list.add(it.toLocalMovieGener()) }
    return list
}