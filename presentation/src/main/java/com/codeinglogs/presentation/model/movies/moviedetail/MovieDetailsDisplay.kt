package com.codeinglogs.presentation.model.movies.moviedetail

import com.codeinglogs.presentation.model.movies.moviedetail.credits.MovieCreditsResponse
import com.codeinglogs.presentation.model.movies.moviedetail.credits.toPresentationMovieCreditsResponse
import com.codeinglogs.presentation.model.movies.moviedetail.images.MovieIMagesResponse
import com.codeinglogs.presentation.model.movies.moviedetail.images.toPresentationMovieIMagesResponse
import com.codeinglogs.presentation.model.movies.moviedetail.info.MovieInfoResponse
import com.codeinglogs.presentation.model.movies.moviedetail.info.toPresentationMovieInfoResponse
import com.codeinglogs.presentation.model.movies.moviedetail.reviews.MovieReviewsResponse
import com.codeinglogs.presentation.model.movies.moviedetail.reviews.toPresentationMovieReviewsResponse
import com.codeinglogs.presentation.model.movies.moviedetail.similar.MovieSimilarResponse
import com.codeinglogs.presentation.model.movies.moviedetail.similar.toPresentationMovieReviewsResponse
import com.codeinglogs.presentation.model.movies.moviedetail.videos.MovieVideosResponse
import com.codeinglogs.presentation.model.movies.moviedetail.videos.toPresentationMovieVideosResponse

import com.codeinglogs.domain.model.movies.moviedetail.MovieDetailsDisplay as DomainMovieDetailsDisplay

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