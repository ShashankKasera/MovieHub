package com.codeinglogs.remote.request

import com.codeinglogs.remote.model.tvshows.tvshowslist.TvShowsListResponse
import retrofit2.http.GET

interface TvShowRequest {

    @GET("trending/tv/day")
    suspend fun getTrendingTvShow(): TvShowsListResponse

    @GET("tv/popular")
    suspend fun getPoPuLarTvShow(): TvShowsListResponse

    @GET("tv/top_rated")
    suspend fun getTopRatedTvShow(): TvShowsListResponse
}