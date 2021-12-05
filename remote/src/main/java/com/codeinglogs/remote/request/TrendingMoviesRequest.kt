package com.codeinglogs.remote.request


import com.codeinglogs.remote.model.trendingmovies.TrendingMoviesList
import retrofit2.http.GET

interface TrendingMoviesRequest {

    @GET("trending/all/day")
    suspend fun getTrendingMovie(): TrendingMoviesList


}