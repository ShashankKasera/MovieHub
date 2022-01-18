package com.codeinglogs.core.di

import com.codeinglogs.data.domainrepositoryimp.TvShowPagingRepositoryDomainImp
import com.codeinglogs.data.repository.pagingtvshow.RemoteTvShowPagingData
import com.codeinglogs.data.store.pagingtvshow.TvShowPagingDataSore
import com.codeinglogs.data.store.pagingtvshow.TvShowPagingDataSoreImpl
import com.codeinglogs.domain.repository.TvShowPagingRepositoryDomain
import com.codeinglogs.remote.datarepositoryimp.RemoteTvShowPagingDataRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TvShowPagingModule {




    @Singleton
    @Provides
    fun getTrendingTvShowRepository(repo : TvShowPagingRepositoryDomainImp): TvShowPagingRepositoryDomain = repo

    @Singleton
    @Provides
    fun getTrendingTvShowRemoteDataSore(dataSoreImpl : TvShowPagingDataSoreImpl): TvShowPagingDataSore = dataSoreImpl

    @Singleton
    @Provides
    fun getRemoteTrendingTvShowRepositorySore(dataSoreRemote : RemoteTvShowPagingDataRepositoryImp): RemoteTvShowPagingData = dataSoreRemote



}