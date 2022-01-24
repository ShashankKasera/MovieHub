package com.codeinglogs.remote.request

import com.codeinglogs.remote.model.movies.movieslist.MoviesListResponse
import com.codeinglogs.remote.model.person.persondetail.externalids.PersonExternalIdsResponse
import com.codeinglogs.remote.model.person.persondetail.images.PersonImagesResponse
import com.codeinglogs.remote.model.person.persondetail.info.PersonInfoResponse
import com.codeinglogs.remote.model.person.persondetail.moviecredits.PersonMovieCreditsResponse
import com.codeinglogs.remote.model.person.persondetail.taggedimages.PersonTaggedImagesResponse
import com.codeinglogs.remote.model.person.persondetail.tvcredits.PersonTvCreditsResponse
import com.codeinglogs.remote.model.person.personlist.PersonListResponse
import com.codeinglogs.remote.model.person.personsearch.PersonSearchResponse
import com.codeinglogs.remote.model.tvshows.tvshowsearch.TvShowSearchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PersonRequest {

    @GET("person/popular")
    suspend fun getPerson(): PersonListResponse

    @GET("person/popular")
    suspend fun getPoPuLarPerson(@Query("page") page : Int): PersonListResponse

    @GET("person/{id}")
    suspend fun getPersonInfo(@Path("id")id : String) : PersonInfoResponse

    @GET("person/{id}/tagged_images")
    suspend fun getPersonTaggedImages(@Path("id")id : String) : PersonTaggedImagesResponse

    @GET("person/{id}/images")
    suspend fun getPersonImages(@Path("id")id : String) : PersonImagesResponse

    @GET("person/{id}/movie_credits")
    suspend fun getPersonMovieCredits(@Path("id")id : String) : PersonMovieCreditsResponse

    @GET("person/{id}/tv_credits")
    suspend fun getPersonTvCredits(@Path("id")id : String) : PersonTvCreditsResponse

    @GET("person/{id}/external_ids")
    suspend fun getPersonExternalIds(@Path("id")id : String) : PersonExternalIdsResponse

    @GET("search/person")
    suspend fun getPersonSearch(@Query("page") page : Int,@Query("query") query : String): PersonSearchResponse

}