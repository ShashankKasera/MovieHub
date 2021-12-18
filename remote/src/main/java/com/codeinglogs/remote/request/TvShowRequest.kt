package com.codeinglogs.remote.request

import com.codeinglogs.remote.model.tvshows.tvshowslist.TvShowsListResponce
import retrofit2.http.GET

interface TvShowRequest {

    @GET("trending/tv/day")
    suspend fun getTrendingTvShow(): TvShowsListResponce

    @GET("tv/popular")
    suspend fun getPoPuLarTvShow(): TvShowsListResponce

    @GET("tv/top_rated")
    suspend fun getTopRatedTvShow(): TvShowsListResponce
}