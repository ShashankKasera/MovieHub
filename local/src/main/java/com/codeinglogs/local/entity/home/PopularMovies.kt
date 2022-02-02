package com.codeinglogs.local.entity.home

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.codeinglogs.local.entity.Movies

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
data class PopularMovies(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    val movieId : Long
)

fun DataMovies.toLocalPopularMovies() = PopularMovies(movieId = id)

fun List<DataMovies>.toLocalPopularMoviesList() : List<PopularMovies>{
    val list = mutableListOf<PopularMovies>()
    this.forEach { list.add(it.toLocalPopularMovies()) }
    return list
}