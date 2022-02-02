package com.codeinglogs.local.entity.moviedetail.image

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.codeinglogs.local.entity.Movies
import com.codeinglogs.data.model.movies.moviedetail.images.MovieBackdrop as DataMovieBackdrop
@Entity
data class MovieBackdrop(
    @PrimaryKey()
    val file_path: String,
    val vote_count: Int,
)

fun MovieBackdrop.toDataMovieBackdrop() = DataMovieBackdrop(
    file_path=file_path,
    vote_count=vote_count
)

fun List<MovieBackdrop>.toDataMovieBackdrop() : List<DataMovieBackdrop>{
    val list = mutableListOf<DataMovieBackdrop>()
    this.forEach { list.add(it.toDataMovieBackdrop()) }
    return list
}

fun DataMovieBackdrop.toLocalMovieBackdrop() = MovieBackdrop(
    file_path=file_path,
    vote_count=vote_count
)

fun List<DataMovieBackdrop>.toLocalMovieBackdropList() : List<MovieBackdrop>{
    val list = mutableListOf<MovieBackdrop>()
    this.forEach { list.add(it.toLocalMovieBackdrop()) }
    return list
}