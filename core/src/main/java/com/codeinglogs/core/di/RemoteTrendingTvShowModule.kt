package com.codeinglogs.core.di

import com.codeinglogs.data.domainrepositoryimp.TrendingTvShowRepositoryDomainImp
import com.codeinglogs.data.repository.trendingtvshow.LocalTrendingTvShowData
import com.codeinglogs.data.repository.trendingtvshow.RemoteTrendingTvShowData
import com.codeinglogs.data.store.trendingtvshow.TrendingTvShowDataSore
import com.codeinglogs.data.store.trendingtvshow.TrendingTvShowDataSoreImpl
import com.codeinglogs.domain.repository.TrendingTvShowRepositoryDomain
import com.codeinglogs.local.dao.MoviesDao
import com.codeinglogs.local.dao.TvShowsDao
import com.codeinglogs.local.datarepositoryimp.LocalTvShowsDataRepositoryImp
import com.codeinglogs.local.db.MovieHubDatabase
import com.codeinglogs.remote.datarepositoryimp.RemoteTrendingTvShowDataRepositoryImp
import com.codeinglogs.remote.request.TvShowRequest
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteTrendingTvShowModule {




    @Singleton
    @Provides
    fun getTrendingTvShowRepository(repo : TrendingTvShowRepositoryDomainImp): TrendingTvShowRepositoryDomain = repo

    @Singleton
    @Provides
    fun getTrendingTvShowRemoteDataSore(dataSoreImpl : TrendingTvShowDataSoreImpl): TrendingTvShowDataSore = dataSoreImpl

    @Singleton
    @Provides
    fun getRemoteTrendingTvShowRepositorySore(dataSoreRemote : RemoteTrendingTvShowDataRepositoryImp): RemoteTrendingTvShowData = dataSoreRemote

    @Singleton
    @Provides
    fun getLocalTrendingTvShowRepositorySore(dataSoreRemote : LocalTvShowsDataRepositoryImp): LocalTrendingTvShowData = dataSoreRemote



}