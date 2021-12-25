package com.codeinglogs.data.model.moviedetail

import com.codeinglogs.data.model.moviedetail.credits.MovieCreditsResponse
import com.codeinglogs.data.model.moviedetail.credits.toDomainMovieCreditsResponse
import com.codeinglogs.data.model.moviedetail.images.MovieIMagesResponse
import com.codeinglogs.data.model.moviedetail.images.toDomainMovieIMagesResponse
import com.codeinglogs.data.model.moviedetail.info.MovieInfoResponse
import com.codeinglogs.data.model.moviedetail.info.toDomainMovieInfoResponse
import com.codeinglogs.data.model.moviedetail.reviews.MovieReviewsResponse
import com.codeinglogs.data.model.moviedetail.reviews.toDomainMovieReviewsResponse
import com.codeinglogs.data.model.moviedetail.similar.MovieSimilarResponse
import com.codeinglogs.data.model.moviedetail.similar.toDomainMovieReviewsResponse
import com.codeinglogs.data.model.moviedetail.videos.MovieVideosResponse
import com.codeinglogs.data.model.moviedetail.videos.toDomainMovieVideosResponse

import com.codeinglogs.domain.model.moviedetail.MovieDetailsDisplay as DomainMovieDetailsDisplay

data class MovieDetailsDisplay(
    val movieCreditsResponse: MovieCreditsResponse,
    val movieIMagesResponse: MovieIMagesResponse,
    val movieInfoResponse: MovieInfoResponse,
    val movieReviewsResponse: MovieReviewsResponse,
    val MovieSimilarResponse: MovieSimilarResponse,
    val MovieVideosResponse: MovieVideosResponse,
)

fun MovieDetailsDisplay.toDomainMovieDetailsDisplay()=DomainMovieDetailsDisplay(
    movieCreditsResponse=movieCreditsResponse.toDomainMovieCreditsResponse(),
    movieIMagesResponse=movieIMagesResponse.toDomainMovieIMagesResponse(),
    movieInfoResponse=movieInfoResponse.toDomainMovieInfoResponse(),
    movieReviewsResponse=movieReviewsResponse.toDomainMovieReviewsResponse(),
    MovieSimilarResponse=MovieSimilarResponse.toDomainMovieReviewsResponse(),
    MovieVideosResponse=MovieVideosResponse.toDomainMovieVideosResponse(),
)