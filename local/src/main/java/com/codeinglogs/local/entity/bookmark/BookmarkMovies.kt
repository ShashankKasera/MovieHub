package com.codeinglogs.local.entity.bookmark

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
data class BookmarkMovies(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    val movieId : Long
)

fun DataMovies.toLocalBookmarkMovies() = BookmarkMovies(movieId = id)

fun List<DataMovies>.toLocalBookmarkMoviesList() : List<BookmarkMovies>{
    val list = mutableListOf<BookmarkMovies>()
    this.forEach { list.add(it.toLocalBookmarkMovies()) }
    return list
}