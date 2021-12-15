package com.codeinglogs.core.di

import android.content.Context
import com.codeinglogs.data.domainrepositoryimp.*
import com.codeinglogs.data.repository.multi.RemoteMultiData
import com.codeinglogs.data.repository.trendingmovies.RemoteTrendingMoviesData
import com.codeinglogs.data.repository.person.RemotePersonData
import com.codeinglogs.data.repository.trendingpersonweek.RemoteTrendingPersonWeekData
import com.codeinglogs.data.repository.trendingtvshow.RemoteTrendingTvShowData
import com.codeinglogs.data.store.multi.MultiDataSore
import com.codeinglogs.data.store.multi.MultiRemoteDataSore
import com.codeinglogs.data.store.person.PersonDataSore
import com.codeinglogs.data.store.person.PersonRemoteDataSore
import com.codeinglogs.data.store.trendingmovies.TrendingMoviesDataSore
import com.codeinglogs.data.store.trendingmovies.TrendingMoviesRemoteDataSore
import com.codeinglogs.data.store.trendingpersonweek.TrendingPersonWeekDataSore
import com.codeinglogs.data.store.trendingpersonweek.TrendingPersonWeekRemoteDataSore
import com.codeinglogs.data.store.trendingtvshow.TrendingTvShowDataSore
import com.codeinglogs.data.store.trendingtvshow.TrendingTvShowRemoteDataSore
import com.codeinglogs.domain.repository.*
import com.codeinglogs.remote.datarepositoryimp.*
import com.codeinglogs.remote.request.PersonRequest
import com.codeinglogs.remote.request.TrendingMoviesRequest
import com.codeinglogs.remote.request.TrendingPersonWeekRequest
import com.codeinglogs.remote.request.TrendingTvShowRequest
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
    fun getTrendingMoviesRequest(retrofit: Retrofit): TrendingMoviesRequest =retrofit.create(
        TrendingMoviesRequest::class.java)


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
    fun getTrendingTvShowRequest(retrofit: Retrofit): TrendingTvShowRequest =retrofit.create(
        TrendingTvShowRequest::class.java)


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
    fun getTrendingPersonWeekRequest(retrofit: Retrofit): TrendingPersonWeekRequest =retrofit.create(TrendingPersonWeekRequest::class.java)

    @Singleton
    @Provides
    fun getTrendingPersonWeekRepository(repo : TrendingPersonWeekRepositoryDomainImp): TrendingPersonWeekRepositoryDomain = repo

    @Singleton
    @Provides
    fun getTrendingPersonWeekRemoteDataSore(dataSore : TrendingPersonWeekRemoteDataSore): TrendingPersonWeekDataSore = dataSore

    @Singleton
    @Provides
    fun getRemoteTrendingPersonWeekRepositorySore(dataSore : TrendingPersonWeekDataRepositoryImp): RemoteTrendingPersonWeekData = dataSore




    @Singleton
    @Provides
    fun getMultiRepository(repo : MultiRepositoryDomainImp): MultiRepositoryDomain = repo

    @Singleton
    @Provides
    fun getMultiRemoteDataSore(dataSore : MultiRemoteDataSore): MultiDataSore = dataSore

    @Singleton
    @Provides
    fun getRemoteMultiRepositorySore(dataSore : MultiDataRepositoryImp): RemoteMultiData = dataSore





}