package com.codeinglogs.core.di

import com.codeinglogs.data.domainrepositoryimp.TvShowSeasonDetailsRepositoryDomainImp
import com.codeinglogs.data.repository.tvshowseasondetails.RemoteTvShowSeasonDetailsData
import com.codeinglogs.data.store.tvshowseasondetails.TvShowSeasonDetailsDataSore
import com.codeinglogs.data.store.tvshowseasondetails.TvShowSeasonDetailsDataSoreImpl
import com.codeinglogs.domain.repository.TvShowSeasonDetailsRepositoryDomain
import com.codeinglogs.remote.datarepositoryimp.RemoteTvShowSeasonDetailsDataRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TvShowSeasonDetailsModule {

    @Singleton
    @Provides
    fun getTvShowSeasonDetailsRepository(repo : TvShowSeasonDetailsRepositoryDomainImp): TvShowSeasonDetailsRepositoryDomain = repo

    @Singleton
    @Provides
    fun getTvShowSeasonDetailsRemoteDataSore(dataSoreImpl : TvShowSeasonDetailsDataSoreImpl): TvShowSeasonDetailsDataSore = dataSoreImpl

    @Singleton
    @Provides
    fun getRemoteTvShowSeasonDetailsRepositorySore(dataSoreRemote : RemoteTvShowSeasonDetailsDataRepositoryImp): RemoteTvShowSeasonDetailsData = dataSoreRemote

}