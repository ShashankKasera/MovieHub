package com.codeinglogs.core.di

import com.codeinglogs.data.domainrepositoryimp.TrendingMoviesRepositoryDomainImp
import com.codeinglogs.data.repository.trendingmovies.LocalTrendingMoviesData
import com.codeinglogs.data.repository.trendingmovies.RemoteTrendingMoviesData
import com.codeinglogs.data.store.trendingmovies.TrendingMoviesDataSore
import com.codeinglogs.data.store.trendingmovies.TrendingMoviesDataSoreImpl
import com.codeinglogs.domain.repository.TrendingMoviesRepositoryDomain
import com.codeinglogs.local.dao.MoviesDao
import com.codeinglogs.local.dao.PersonsDao
import com.codeinglogs.local.dao.TrendingMoviesDao
import com.codeinglogs.local.datarepositoryimp.LocalMoviesDataRepositoryImp
import com.codeinglogs.local.db.MovieHubDatabase
import com.codeinglogs.remote.datarepositoryimp.RemoteTrendingMoviesDataRepositoryImp
import com.codeinglogs.remote.request.MoviesRequest
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TrendingMoviesModule {


    @Singleton
    @Provides
    fun getTrendingMoviesRepository(repo : TrendingMoviesRepositoryDomainImp): TrendingMoviesRepositoryDomain = repo

    @Singleton
    @Provides
    fun getTrendingMoviesRemoteDataSore(dataSoreImpl : TrendingMoviesDataSoreImpl): TrendingMoviesDataSore = dataSoreImpl

    @Singleton
    @Provides
    fun getRemoteTrendingMoviesRepositorySore(dataSoreRemote : RemoteTrendingMoviesDataRepositoryImp): RemoteTrendingMoviesData = dataSoreRemote


    @Singleton
    @Provides
    fun getLocalTrendingMoviesData(dataSoreRemote : LocalMoviesDataRepositoryImp): LocalTrendingMoviesData = dataSoreRemote


}