package com.codeinglogs.remote.request


import com.codeinglogs.remote.model.movies.moviedetail.credits.MovieCreditsResponse
import com.codeinglogs.remote.model.movies.moviedetail.images.MovieImagesResponse
import com.codeinglogs.remote.model.movies.moviedetail.info.MovieInfoResponse
import com.codeinglogs.remote.model.movies.moviedetail.reviews.MovieReviewsResponse
import com.codeinglogs.remote.model.movies.moviedetail.similar.MovieSimilarResponse
import com.codeinglogs.remote.model.movies.moviedetail.videos.MovieVideosResponse
import com.codeinglogs.remote.model.movies.movieslist.MoviesListResponse
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



    @GET("trending/movie/day")
    suspend fun getTrendingMovie(@Query("page") page : Int): MoviesListResponse

    @GET("trending/movie/day")
    suspend fun getTrendingMovie(): MoviesListResponse

    @GET("movie/popular")
    suspend fun getPoPuLarMovie(): MoviesListResponse

    @GET("movie/popular")
    suspend fun getPoPuLarMovie(@Query("page") page : Int): MoviesListResponse

    @GET("movie/top_rated")
    suspend fun getTopRatedMovie(): MoviesListResponse

    @GET("movie/top_rated")
    suspend fun getTopRatedMovie(@Query("page") page : Int): MoviesListResponse


}