package com.codeinglogs.remote.request


import com.codeinglogs.remote.model.movies.movieslist.MoviesListResponce
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesRequest {

    @GET("trending/all/day")
    suspend fun getTrendingMovie(@Query("page") page : Int): MoviesListResponce

    @GET("trending/all/day")
    suspend fun getTrendingMovie(): MoviesListResponce

    @GET("movie/popular")
    suspend fun getPoPuLarMovie(): MoviesListResponce

    @GET("movie/top_rated")
    suspend fun getTopRatedMovie(): MoviesListResponce


}