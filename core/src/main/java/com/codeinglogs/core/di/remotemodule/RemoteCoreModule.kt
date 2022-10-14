package com.codeinglogs.core.di.remotemodule

import android.content.Context
import com.codeinglogs.remote.request.MoviesRequest
import com.codeinglogs.remote.request.PersonRequest
import com.codeinglogs.remote.request.TvShowRequest
import com.codeinglogs.remote.util.nerwork.API_KEY
import com.codeinglogs.remote.util.nerwork.BASE_URL
import com.codeinglogs.remote.util.nerwork.NetworkInterceptor
import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RemoteCoreModule {

    @Singleton
    @Provides
    @Named("BaseUrl")
    fun getBaseUrl():String = BASE_URL

    @Provides
    @Singleton
    fun getOkHttp(@ApplicationContext appContext: Context) = OkHttpClient.Builder()
        //.addInterceptor(NetworkInterceptor(appContext))
        .addNetworkInterceptor(Interceptor { chain ->
            val originalRequest = chain.request()
            val newHttpUrl = originalRequest.url.newBuilder().addQueryParameter("api_key", API_KEY).build()
            val newRequest = originalRequest.newBuilder().url(newHttpUrl).build()
            chain.proceed(newRequest)
        })
        .addNetworkInterceptor(StethoInterceptor())
        .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    @Singleton
    @Provides
    fun getRetrofit(@Named("BaseUrl") baseUrl:String,okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder().baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()


    @Singleton
    @Provides
    fun getMoviesRequest(retrofit: Retrofit): MoviesRequest =retrofit.create(MoviesRequest::class.java)

    @Singleton
    @Provides
    fun getPersonRequest(retrofit: Retrofit): PersonRequest =retrofit.create(PersonRequest::class.java)

    @Singleton
    @Provides
    fun getTrendingTvShowRequest(retrofit: Retrofit): TvShowRequest =retrofit.create(TvShowRequest::class.java)

}