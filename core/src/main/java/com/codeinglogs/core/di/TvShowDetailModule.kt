package com.codeinglogs.core.di

import com.codeinglogs.data.domainrepositoryimp.TvShowDetailRepositoryDomainImp
import com.codeinglogs.data.repository.moviedetails.LocalMovieDetailData
import com.codeinglogs.data.repository.tvshowetails.LocalTvShowDetailData
import com.codeinglogs.data.repository.tvshowetails.RemoteTvShowDetailData
import com.codeinglogs.data.store.tvshowdetails.TvShowDetailDataSoreImpl
import com.codeinglogs.data.store.tvshowdetails.TvShowDetailsDataSore
import com.codeinglogs.domain.repository.TvShowDetailRepositoryDomain
import com.codeinglogs.local.datarepositoryimp.LocalMovieDetailsDataRepositoryImp
import com.codeinglogs.local.datarepositoryimp.LocalTvShowDetailsDataRepositoryImp
import com.codeinglogs.remote.datarepositoryimp.RemoteTvShowDetailDataRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TvShowDetailModule {

    @Singleton
    @Provides
    fun getTvShowDetailRepository(repo : TvShowDetailRepositoryDomainImp): TvShowDetailRepositoryDomain = repo

    @Singleton
    @Provides
    fun getTvShowDetailRemoteDataSore(dataSoreImpl : TvShowDetailDataSoreImpl): TvShowDetailsDataSore = dataSoreImpl

    @Singleton
    @Provides
    fun getRemoteTvShowDetailRepositorySore(dataSoreRemote : RemoteTvShowDetailDataRepositoryImp): RemoteTvShowDetailData = dataSoreRemote

    @Singleton
    @Provides
    fun getLocalTvShowDetailDataRepositoryImp(dataSoreRemote : LocalTvShowDetailsDataRepositoryImp): LocalTvShowDetailData = dataSoreRemote

}