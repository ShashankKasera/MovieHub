package com.codeinglogs.core.di

import android.content.Context
import com.codeinglogs.data.domainrepositoryimp.*
import com.codeinglogs.data.repository.home.RemoteHomeData
import com.codeinglogs.data.repository.trendingmovies.RemoteTrendingMoviesData
import com.codeinglogs.data.repository.person.RemotePersonData
import com.codeinglogs.data.repository.trendingtvshow.RemoteTrendingTvShowData
import com.codeinglogs.data.store.home.HomeDataSore
import com.codeinglogs.data.store.home.HomeRemoteDataSore
import com.codeinglogs.data.store.person.PersonDataSore
import com.codeinglogs.data.store.person.PersonRemoteDataSore
import com.codeinglogs.data.store.trendingmovies.TrendingMoviesDataSore
import com.codeinglogs.data.store.trendingmovies.TrendingMoviesRemoteDataSore
import com.codeinglogs.data.store.trendingtvshow.TrendingTvShowDataSore
import com.codeinglogs.data.store.trendingtvshow.TrendingTvShowRemoteDataSore
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
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Singleton
    @Provides
    fun getBaseUrl():String = BASE_URL

    @Provides
    @Singleton
    fun getOkHttp(@ApplicationContext appContext: Context) = OkHttpClient.Builder()
        .addInterceptor(NetworkInterceptor(appContext))
        .build()

    @Singleton
    @Provides
    fun getRetrofit(baseUrl:String,okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder().baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()


    @Singleton
    @Provides
    fun getTrendingMoviesRequest(retrofit: Retrofit): MoviesRequest =retrofit.create(
        MoviesRequest::class.java)


    @Singleton
    @Provides
    fun getTrendingMoviesRepository(repo : TrendingMoviesRepositoryDomainImp): TrendingMoviesRepositoryDomain = repo

     @Singleton
     @Provides
     fun getTrendingMoviesRemoteDataSore(dataSore : TrendingMoviesRemoteDataSore): TrendingMoviesDataSore = dataSore

     @Singleton
     @Provides
     fun getRemoteTrendingMoviesRepositorySore(dataSore : TrendingMoviesDataRepositoryImp): RemoteTrendingMoviesData = dataSore



    @Singleton
    @Provides
    fun getPersonRequest(retrofit: Retrofit): PersonRequest =retrofit.create(
        PersonRequest::class.java)


    @Singleton
    @Provides
    fun getPersonRepository(repo : PersonRepositoryDomainImp): PersonRepositoryDomain = repo

    @Singleton
    @Provides
    fun getPersonDataSore(dataSore : PersonRemoteDataSore): PersonDataSore = dataSore

    @Singleton
    @Provides
    fun getRemotePersonRepositorySore(dataSore : PersonDataRepositoryImp): RemotePersonData = dataSore


    @Singleton
    @Provides
    fun getTrendingTvShowRequest(retrofit: Retrofit): TvShowRequest =retrofit.create(
        TvShowRequest::class.java)


    @Singleton
    @Provides
    fun getTrendingTvShowRepository(repo : TrendingTvShowRepositoryDomainImp): TrendingTvShowRepositoryDomain = repo

    @Singleton
    @Provides
    fun getTrendingTvShowRemoteDataSore(dataSore : TrendingTvShowRemoteDataSore): TrendingTvShowDataSore = dataSore

    @Singleton
    @Provides
    fun getRemoteTrendingTvShowRepositorySore(dataSore : TrendingTvShowDataRepositoryImp): RemoteTrendingTvShowData = dataSore



    @Singleton
    @Provides
    fun getMultiRepository(repo : HomeRepositoryDomainImp): HomeRepositoryDomain = repo

    @Singleton
    @Provides
    fun getMultiRemoteDataSore(dataSore : HomeRemoteDataSore): HomeDataSore = dataSore

    @Singleton
    @Provides
    fun getRemoteMultiRepositorySore(dataSore : HomeDataRepositoryImp): RemoteHomeData = dataSore





}