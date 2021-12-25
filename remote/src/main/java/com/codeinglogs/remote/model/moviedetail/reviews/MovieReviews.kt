package com.codeinglogs.remote.model.moviedetail.reviews
import com.codeinglogs.data.model.moviedetail.reviews.MovieReviews as DataMovieReviews

data class MovieReviews(
    val author: String?,
    val author_details: AuthorDetails?,
    val content: String?,
    val created_at: String?,
    val id: String?,
    val updated_at: String?,
    val url: String
)

fun MovieReviews.toDataMovieReviews()=DataMovieReviews(

    author =author?:"",
    content =content?:"",
    created_at =created_at?:"",
    id =id?:"",
    updated_at =updated_at?:"",
)