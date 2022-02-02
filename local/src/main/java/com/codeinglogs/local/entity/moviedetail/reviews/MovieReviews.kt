package com.codeinglogs.local.entity.moviedetail.reviews

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.codeinglogs.data.model.movies.moviedetail.reviews.MovieReviews as DataMovieReviews

@Entity
data class MovieReviews(
    @PrimaryKey
    val id: String,
    val author: String,
    val content: String,
    val created_at: String,
    val updated_at: String,
)

fun MovieReviews.toDataMovieReviews() = DataMovieReviews(
        author =author,
        content =content,
        created_at =created_at,
        id =id,
        updated_at =updated_at,
    )

fun List<MovieReviews>.toDataMovieReviews() : List<DataMovieReviews>{
    val list = mutableListOf<DataMovieReviews>()
    this.forEach { list.add(it.toDataMovieReviews()) }
    return list
}

fun DataMovieReviews.toLocalMovieReviews() = MovieReviews(
    author =author,
    content =content,
    created_at =created_at,
    id =id,
    updated_at =updated_at,
)

fun List<DataMovieReviews>.toLocalMovieReviewsList() : List<MovieReviews>{
    val list = mutableListOf<MovieReviews>()
    this.forEach { list.add(it.toLocalMovieReviews()) }
    return list
}