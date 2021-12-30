package com.codeinglogs.domain.model.movies.moviedetail

import com.codeinglogs.domain.model.movies.moviedetail.credits.MovieCreditsResponse
import com.codeinglogs.domain.model.movies.moviedetail.images.MovieIMagesResponse
import com.codeinglogs.domain.model.movies.moviedetail.info.MovieInfoResponse
import com.codeinglogs.domain.model.movies.moviedetail.reviews.MovieReviewsResponse
import com.codeinglogs.domain.model.movies.moviedetail.similar.MovieSimilarResponse
import com.codeinglogs.domain.model.movies.moviedetail.videos.MovieVideosResponse

data class MovieDetailsDisplay(
    val movieCreditsResponse: MovieCreditsResponse,
    val movieIMagesResponse: MovieIMagesResponse,
    val movieInfoResponse: MovieInfoResponse,
    val movieReviewsResponse: MovieReviewsResponse,
    val MovieSimilarResponse: MovieSimilarResponse,
    val MovieVideosResponse: MovieVideosResponse,
)