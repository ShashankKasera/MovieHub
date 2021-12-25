package com.codeinglogs.core.di.remotemodule

import android.content.Context
import com.codeinglogs.data.domainrepositoryimp.*
import com.codeinglogs.data.repository.home.RemoteHomeData
import com.codeinglogs.data.repository.trendingmovies.RemoteTrendingMoviesData
import com.codeinglogs.data.repository.person.RemotePersonData
import com.codeinglogs.data.repository.trendingtvshow.RemoteTrendingTvShowData
import com.codeinglogs.data.store.home.HomeDataSore
import com.codeinglogs.data.store.home.HomeRemoteDataSore
import com.codeinglogs.data.store.person.PersonDataSore
import com.codeinglogs.data.store.person.PersonDataSoreImpl
import com.codeinglogs.data.store.trendingmovies.TrendingMoviesDataSore
import com.codeinglogs.data.store.trendingmovies.TrendingMoviesDataSoreImpl
import com.codeinglogs.data.store.trendingtvshow.TrendingTvShowDataSore
import com.codeinglogs.data.store.trendingtvshow.TrendingTvShowDataSoreImpl
import com.codeinglogs.domain.repository.*
import com.codeinglogs.remote.datarepositoryimp.*
import com.codeinglogs.remote.request.PersonRequest
import com.codeinglogs.remote.request.MoviesRequest
import com.codeinglogs.remote.request.TvShowRequest
import com.codeinglogs.remote.util.nerwork.BASE_URL
import com.codeinglogs.remote.util.nerwork.NetworkInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
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
        .addInterceptor(NetworkInterceptor(appContext))
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