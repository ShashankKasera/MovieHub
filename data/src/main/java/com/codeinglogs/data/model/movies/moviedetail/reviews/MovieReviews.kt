package com.codeinglogs.data.model.movies.moviedetail.reviews
import com.codeinglogs.domain.model.movies.moviedetail.reviews.MovieReviews as DomainMovieReviews

data class MovieReviews(
    val author: String,
    val content: String,
    val created_at: String,
    val id: String  ,
    val updated_at: String,
)

fun MovieReviews.toDomainMovieReviews()= DomainMovieReviews(

    author =author,
    content =content,
    created_at =created_at,
    id =id,
    updated_at =updated_at,
)