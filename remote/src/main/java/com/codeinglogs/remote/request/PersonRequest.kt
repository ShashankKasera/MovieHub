package com.codeinglogs.remote.request

import com.codeinglogs.remote.model.person.PersonList
import retrofit2.http.GET

interface PersonRequest {

    @GET("person/popular")
    suspend fun getPerson(): PersonList
}