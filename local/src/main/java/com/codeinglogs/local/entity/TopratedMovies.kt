package com.codeinglogs.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

import com.codeinglogs.data.model.movies.movieslist.Movies as DataMovies

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Movies::class,
            parentColumns = ["id"],
            childColumns = ["movieId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class TopRatedMovies(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    val movieId : Long
)


fun DataMovies.toLocalTopRatedMovies() = TopRatedMovies(movieId = id)

fun List<DataMovies>.toLocalTopRatedMoviesList() : List<TopRatedMovies>{
    val list = mutableListOf<TopRatedMovies>()
    this.forEach { list.add(it.toLocalTopRatedMovies()) }
    return list
}