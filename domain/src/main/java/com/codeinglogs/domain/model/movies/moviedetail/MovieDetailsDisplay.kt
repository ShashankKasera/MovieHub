package com.codeinglogs.domain.model.movies.moviedetail

import com.codeinglogs.domain.model.movies.mylist.MyMovieList
import com.codeinglogs.domain.model.movies.moviedetail.credits.MovieCreditsResponse
import com.codeinglogs.domain.model.movies.moviedetail.images.MovieIMagesResponse
import com.codeinglogs.domain.model.movies.moviedetail.info.MovieInfoResponse
import com.codeinglogs.domain.model.movies.moviedetail.reviews.MovieReviewsResponse
import com.codeinglogs.domain.model.movies.moviedetail.videos.MovieVideosResponse
import com.codeinglogs.domain.model.movies.mylist.MyMovieListDetails
import com.codeinglogs.domain.model.movies.mylist.MyMovieListDisplay

data class MovieDetailsDisplay(
    val movieCreditsResponse: MovieCreditsResponse,
    val movieIMagesResponse: MovieIMagesResponse,
    val movieInfoResponse: MovieInfoResponse,
    val movieReviewsResponse: MovieReviewsResponse,
    val MovieVideosResponse: MovieVideosResponse,
    val myMovieList: List<MyMovieListDisplay>,
    val Bookmark: Boolean,

    )