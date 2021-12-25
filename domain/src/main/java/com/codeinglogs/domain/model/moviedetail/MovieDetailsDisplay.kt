package com.codeinglogs.domain.model.moviedetail

import com.codeinglogs.domain.model.moviedetail.credits.MovieCreditsResponse
import com.codeinglogs.domain.model.moviedetail.images.MovieIMagesResponse
import com.codeinglogs.domain.model.moviedetail.info.MovieInfoResponse
import com.codeinglogs.domain.model.moviedetail.reviews.MovieReviewsResponse
import com.codeinglogs.domain.model.moviedetail.similar.MovieSimilarResponse
import com.codeinglogs.domain.model.moviedetail.videos.MovieVideosResponse

data class MovieDetailsDisplay(
    val movieCreditsResponse: MovieCreditsResponse,
    val movieIMagesResponse: MovieIMagesResponse,
    val movieInfoResponse: MovieInfoResponse,
    val movieReviewsResponse: MovieReviewsResponse,
    val MovieSimilarResponse: MovieSimilarResponse,
    val MovieVideosResponse: MovieVideosResponse,
)