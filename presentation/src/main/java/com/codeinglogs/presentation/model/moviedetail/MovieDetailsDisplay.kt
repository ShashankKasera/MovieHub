package com.codeinglogs.presentation.model.moviedetail

import com.codeinglogs.presentation.model.moviedetail.credits.MovieCreditsResponse
import com.codeinglogs.presentation.model.moviedetail.credits.toPresentationMovieCreditsResponse
import com.codeinglogs.presentation.model.moviedetail.images.MovieIMagesResponse
import com.codeinglogs.presentation.model.moviedetail.images.toPresentationMovieIMagesResponse
import com.codeinglogs.presentation.model.moviedetail.info.MovieInfoResponse
import com.codeinglogs.presentation.model.moviedetail.info.toPresentationMovieInfoResponse
import com.codeinglogs.presentation.model.moviedetail.reviews.MovieReviewsResponse
import com.codeinglogs.presentation.model.moviedetail.reviews.toPresentationMovieReviewsResponse
import com.codeinglogs.presentation.model.moviedetail.similar.MovieSimilarResponse
import com.codeinglogs.presentation.model.moviedetail.similar.toPresentationMovieReviewsResponse
import com.codeinglogs.presentation.model.moviedetail.videos.MovieVideosResponse
import com.codeinglogs.presentation.model.moviedetail.videos.toPresentationMovieVideosResponse

import com.codeinglogs.domain.model.moviedetail.MovieDetailsDisplay as DomainMovieDetailsDisplay

data class MovieDetailsDisplay(
    val movieCreditsResponse: MovieCreditsResponse,
    val movieIMagesResponse: MovieIMagesResponse,
    val movieInfoResponse: MovieInfoResponse,
    val movieReviewsResponse: MovieReviewsResponse,
    val MovieSimilarResponse: MovieSimilarResponse,
    val MovieVideosResponse: MovieVideosResponse,
)

fun DomainMovieDetailsDisplay.toPresentationMovieDetailsDisplay()=MovieDetailsDisplay(
    movieCreditsResponse=movieCreditsResponse.toPresentationMovieCreditsResponse(),
    movieIMagesResponse=movieIMagesResponse.toPresentationMovieIMagesResponse(),
    movieInfoResponse=movieInfoResponse.toPresentationMovieInfoResponse(),
    movieReviewsResponse=movieReviewsResponse.toPresentationMovieReviewsResponse(),
    MovieSimilarResponse=MovieSimilarResponse.toPresentationMovieReviewsResponse(),
    MovieVideosResponse=MovieVideosResponse.toPresentationMovieVideosResponse(),
)