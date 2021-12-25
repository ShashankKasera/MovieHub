package com.codeinglogs.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import com.codeinglogs.data.model.movies.movieslist.Movies as DataMovies

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Movies::class,
            parentColumns = ["id"],
            childColumns = ["movieId"],
            onDelete = CASCADE
        )
    ]
)
data class TrendingMovies(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    val movieId : Long
)

fun DataMovies.toLocalTrendingMovies() = TrendingMovies(movieId = id)

fun List<DataMovies>.toLocalTrendingMoviesList() : List<TrendingMovies>{
    val list = mutableListOf<TrendingMovies>()
    this.forEach { list.add(it.toLocalTrendingMovies()) }
    return list
}



