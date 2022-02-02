package com.codeinglogs.data.model.movies.moviedetail

import com.codeinglogs.data.model.movies.moviedetail.credits.MovieCreditsResponse
import com.codeinglogs.data.model.movies.moviedetail.credits.toDomainMovieCreditsResponse
import com.codeinglogs.data.model.movies.moviedetail.images.MovieIMagesResponse
import com.codeinglogs.data.model.movies.moviedetail.images.toDomainMovieIMagesResponse
import com.codeinglogs.data.model.movies.moviedetail.info.MovieInfoResponse
import com.codeinglogs.data.model.movies.moviedetail.info.toDomainMovieInfoResponse
import com.codeinglogs.data.model.movies.moviedetail.reviews.MovieReviewsResponse
import com.codeinglogs.data.model.movies.moviedetail.reviews.toDomainMovieReviewsResponse
import com.codeinglogs.data.model.movies.moviedetail.similar.MovieSimilarResponse
import com.codeinglogs.data.model.movies.moviedetail.similar.toDomainMovieReviewsResponse
import com.codeinglogs.data.model.movies.moviedetail.videos.MovieVideosResponse
import com.codeinglogs.data.model.movies.moviedetail.videos.toDomainMovieVideosResponse

import com.codeinglogs.domain.model.movies.moviedetail.MovieDetailsDisplay as DomainMovieDetailsDisplay

data class MovieDetailsDisplay(
    val movieCreditsResponse: MovieCreditsResponse,
    val movieIMagesResponse: MovieIMagesResponse,
    val movieInfoResponse: MovieInfoResponse,
    val movieReviewsResponse: MovieReviewsResponse,
    val MovieVideosResponse: MovieVideosResponse,
)

fun MovieDetailsDisplay.toDomainMovieDetailsDisplay()=DomainMovieDetailsDisplay(
    movieCreditsResponse=movieCreditsResponse.toDomainMovieCreditsResponse(),
    movieIMagesResponse=movieIMagesResponse.toDomainMovieIMagesResponse(),
    movieInfoResponse=movieInfoResponse.toDomainMovieInfoResponse(),
    movieReviewsResponse=movieReviewsResponse.toDomainMovieReviewsResponse(),
    MovieVideosResponse=MovieVideosResponse.toDomainMovieVideosResponse(),
)