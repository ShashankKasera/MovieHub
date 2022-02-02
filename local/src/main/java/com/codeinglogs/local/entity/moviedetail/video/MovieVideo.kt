package com.codeinglogs.local.entity.moviedetail.video

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.codeinglogs.data.model.movies.moviedetail.videos.MovieVideo as DataMovieVideo

@Entity
data class MovieVideo(
    @PrimaryKey
    val id: String,
    val key: String,
    val name: String,
    val published_at: String,
    val site: String,
    val type: String
)

fun MovieVideo.toDataMovieVideo() =
    DataMovieVideo(
        id =id,
        key =key,
        name =name,
        published_at =published_at,
        site =site,
        type =type
    )

fun List<MovieVideo>.toDataMovieVideo() : List<DataMovieVideo>{
    val list = mutableListOf<DataMovieVideo>()
    this.forEach { list.add(it.toDataMovieVideo()) }
    return list
}

fun DataMovieVideo.toLocalMovieVideo() = MovieVideo(
    id =id,
    key =key,
    name =name,
    published_at =published_at,
    site =site,
    type =type
)

fun List<DataMovieVideo>.toLocalMovieVideo() : List<MovieVideo>{
    val list = mutableListOf<MovieVideo>()
    this.forEach { list.add(it.toLocalMovieVideo()) }
    return list
}