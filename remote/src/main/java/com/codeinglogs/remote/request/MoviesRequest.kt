package com.codeinglogs.remote.request


import com.codeinglogs.remote.model.moviedetail.credits.MovieCreditsResponse
import com.codeinglogs.remote.model.moviedetail.images.MovieImagesResponse
import com.codeinglogs.remote.model.moviedetail.info.MovieInfoResponse
import com.codeinglogs.remote.model.moviedetail.reviews.MovieReviewsResponse
import com.codeinglogs.remote.model.moviedetail.similar.MovieSimilarResponse
import com.codeinglogs.remote.model.moviedetail.videos.MovieVideosResponse
import com.codeinglogs.remote.model.movies.movieslist.MoviesListResponce
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesRequest {



    @GET("movie/{movie_id}")
    suspend fun getMovieInfo (@Path("movie_id") movie : String ) : MovieInfoResponse

    @GET("movie/{id}/credits")
    suspend fun getMovieCredits(@Path("id")id : String): MovieCreditsResponse

    @GET("movie/{id}/videos")
    suspend fun getMovieVideos(@Path("id")id : String): MovieVideosResponse

    @GET("movie/{id}/images")
    suspend fun getMovieImages(@Path("id")id : String): MovieImagesResponse

    @GET("movie/{id}/reviews")
    suspend fun getMovieReviews(@Path("id")id : String): MovieReviewsResponse

    @GET("movie/{id}/similar")
    suspend fun getMovieSimilar(@Path("id")id : String): MovieSimilarResponse



    @GET("trending/all/day")
    suspend fun getTrendingMovie(@Query("page") page : Int): MoviesListResponce

    @GET("trending/all/day")
    suspend fun getTrendingMovie(): MoviesListResponce

    @GET("movie/popular")
    suspend fun getPoPuLarMovie(): MoviesListResponce

    @GET("movie/top_rated")
    suspend fun getTopRatedMovie(): MoviesListResponce


}