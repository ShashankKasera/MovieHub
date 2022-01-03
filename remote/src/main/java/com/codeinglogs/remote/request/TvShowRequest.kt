package com.codeinglogs.remote.request

import com.codeinglogs.remote.model.tvshows.tvshowdetails.credits.TvShowCreditsResponse
import com.codeinglogs.remote.model.tvshows.tvshowdetails.image.TvShowImageResponse
import com.codeinglogs.remote.model.tvshows.tvshowdetails.info.TvShowInfoResponse
import com.codeinglogs.remote.model.tvshows.tvshowdetails.reviews.TvShowReviewsResponse
import com.codeinglogs.remote.model.tvshows.tvshowdetails.similar.TvShowSimilarResponse
import com.codeinglogs.remote.model.tvshows.tvshowdetails.video.TvShowsVideosResponse
import com.codeinglogs.remote.model.tvshows.tvshowslist.TvShowsListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface TvShowRequest {

    @GET("trending/tv/day")
    suspend fun getTrendingTvShow(): TvShowsListResponse

    @GET("tv/popular")
    suspend fun getPoPuLarTvShow(): TvShowsListResponse

    @GET("tv/top_rated")
    suspend fun getTopRatedTvShow(): TvShowsListResponse

    @GET("tv/{id}")
    suspend fun getTvShowInfo(@Path("id")id : String) : TvShowInfoResponse

    @GET("tv/{id}/credits")
    suspend fun getTvShowCredits(@Path("id")id : String): TvShowCreditsResponse

    @GET("tv/{id}/videos")
    suspend fun getTvShowVideos(@Path("id")id : String): TvShowsVideosResponse

    @GET("tv/{id}/images")
    suspend fun getTvShowImages(@Path("id")id : String): TvShowImageResponse

    @GET("tv/{id}/reviews")
    suspend fun getTvShowReviews(@Path("id")id : String): TvShowReviewsResponse

    @GET("tv/{id}/similar")
    suspend fun getTvShowSimilar(@Path("id")id : String): TvShowSimilarResponse
}