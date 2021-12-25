package com.codeinglogs.core.di

import com.codeinglogs.data.domainrepositoryimp.HomeRepositoryDomainImp
import com.codeinglogs.data.domainrepositoryimp.MovieDetailRepositoryDomainImp
import com.codeinglogs.data.repository.moviedetails.RemoteMovieDetailData
import com.codeinglogs.data.repository.person.LocalPersonData
import com.codeinglogs.data.repository.person.RemotePersonData
import com.codeinglogs.data.store.home.HomeDataSore
import com.codeinglogs.data.store.home.HomeRemoteDataSore
import com.codeinglogs.data.store.moviedetails.MovieDetailDataSoreImpl
import com.codeinglogs.data.store.moviedetails.MovieDetailsDataSore
import com.codeinglogs.domain.repository.HomeRepositoryDomain
import com.codeinglogs.domain.repository.MovieDetailRepositoryDomain
import com.codeinglogs.local.datarepositoryimp.LocalPersonDataRepositoryImp
import com.codeinglogs.remote.datarepositoryimp.RemoteMovieDetailDataRepositoryImp
import com.codeinglogs.remote.datarepositoryimp.RemotePersonDataRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieDetailModule {

    @Singleton
    @Provides
    fun getMovieDetailRepository(repo : MovieDetailRepositoryDomainImp): MovieDetailRepositoryDomain = repo

    @Singleton
    @Provides
    fun getMovieDetailRemoteDataSore(dataSoreImpl : MovieDetailDataSoreImpl): MovieDetailsDataSore = dataSoreImpl

    @Singleton
    @Provides
    fun getRemoteMovieDetailRepositorySore(dataSoreRemote : RemoteMovieDetailDataRepositoryImp): RemoteMovieDetailData = dataSoreRemote

}