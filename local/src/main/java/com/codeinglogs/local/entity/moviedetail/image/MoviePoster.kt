package com.codeinglogs.local.entity.moviedetail.image

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.codeinglogs.data.model.movies.moviedetail.images.MoviePoster as DataMoviePoster

@Entity
data class MoviePoster(
    @PrimaryKey()
    val file_path: String,
    val vote_count: Int,
)

fun MoviePoster.toDataMoviePoster() = DataMoviePoster(
        file_path = file_path,
        vote_count = vote_count
    )

fun List<MoviePoster>.toDataMoviePoster() : List<DataMoviePoster>{
    val list = mutableListOf<DataMoviePoster>()
    this.forEach { list.add(it.toDataMoviePoster()) }
    return list
}

fun DataMoviePoster.toLocalMoviePoster() = MoviePoster(
    file_path=file_path,
    vote_count=vote_count
)

fun List<DataMoviePoster>.toLocalMoviePosterList() : List<MoviePoster>{
    val list = mutableListOf<MoviePoster>()
    this.forEach { list.add(it.toLocalMoviePoster()) }
    return list
}