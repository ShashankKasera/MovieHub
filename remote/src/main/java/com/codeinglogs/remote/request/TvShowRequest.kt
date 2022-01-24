package com.codeinglogs.remote.request

import com.codeinglogs.remote.model.movies.moviedetail.similar.MovieSimilarResponse
import com.codeinglogs.remote.model.movies.moviesearch.MovieSearchResponse
import com.codeinglogs.remote.model.movies.movieslist.MoviesListResponse
import com.codeinglogs.remote.model.tvshows.tvshowseasondetails.seasonimage.TvShowSeasonImageResponse
import com.codeinglogs.remote.model.tvshows.tvshowdetails.credits.TvShowCreditsResponse
import com.codeinglogs.remote.model.tvshows.tvshowdetails.image.TvShowImageResponse
import com.codeinglogs.remote.model.tvshows.tvshowdetails.info.TvShowInfoResponse
import com.codeinglogs.remote.model.tvshows.tvshowdetails.reviews.TvShowReviewsResponse
import com.codeinglogs.remote.model.tvshows.tvshowseasondetails.seasons.TvShowSeasonsResponse
import com.codeinglogs.remote.model.tvshows.tvshowdetails.similar.TvShowSimilarResponse
import com.codeinglogs.remote.model.tvshows.tvshowdetails.video.TvShowsVideosResponse
import com.codeinglogs.remote.model.tvshows.tvshowsearch.TvShowSearchResponse
import com.codeinglogs.remote.model.tvshows.tvshowseasondetails.seasoncredits.TvShowSeasonsCreditsResponse
import com.codeinglogs.remote.model.tvshows.tvshowseasondetails.seasonvideo.TvShowsSeasonVideosResponse
import com.codeinglogs.remote.model.tvshows.tvshowslist.TvShowsListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TvShowRequest {

    @GET("trending/tv/day")
    suspend fun getTrendingTvShow(): TvShowsListResponse

    @GET("trending/tv/day")
    suspend fun getTrendingTvShow(@Query("page") page : Int): TvShowsListResponse

    @GET("tv/popular")
    suspend fun getPoPuLarTvShow(): TvShowsListResponse

    @GET("tv/popular")
    suspend fun getPoPuLarTvShow(@Query("page") page : Int): TvShowsListResponse

    @GET("tv/top_rated")
    suspend fun getTopRatedTvShow(): TvShowsListResponse

    @GET("tv/top_rated")
    suspend fun getTopRatedTvShow(@Query("page") page : Int): TvShowsListResponse



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

    @GET("tv/{id}/similar")
    suspend fun getTvShowSimilar(@Path("id")id : String,@Query("page") page : Int): TvShowSimilarResponse

    @GET("tv/{id}/season/{season_number}")
    suspend fun getTvShowSeason(@Path("id",)id : String,@Path("season_number",)season_number : Int): TvShowSeasonsResponse

    @GET("tv/{tv_id}/season/{season_number}/credits")
    suspend fun getTvShowSeasonCredits(@Path("tv_id",)id : String,@Path("season_number",)season_number : Int): TvShowSeasonsCreditsResponse

    @GET("tv/{tv_id}/season/{season_number}/images")
    suspend fun getTvShowSeasonImages(@Path("tv_id",)id : String,@Path("season_number",)season_number : Int): TvShowSeasonImageResponse

    @GET("tv/{tv_id}/season/{season_number}/videos")
    suspend fun getTvShowSeasonVideos(@Path("tv_id",)id : String,@Path("season_number",)season_number : Int): TvShowsSeasonVideosResponse

    @GET("search/tv")
    suspend fun getTvShowSearch(@Query("page") page : Int,@Query("query") query : String): TvShowSearchResponse

}