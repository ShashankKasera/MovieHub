package com.codeinglogs.remote.request


import com.codeinglogs.remote.model.trendingmovies.TrendingMoviesList
import retrofit2.http.GET
import retrofit2.http.Query

interface TrendingMoviesRequest {

    @GET("trending/all/day")
    suspend fun getTrendingMovie(@Query("page") page : Int): TrendingMoviesList

    @GET("trending/all/day")
    suspend fun getTrendingMovie(): TrendingMoviesList


}