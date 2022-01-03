package com.codeinglogs.core.di

import com.codeinglogs.data.domainrepositoryimp.MovieDetailRepositoryDomainImp
import com.codeinglogs.data.repository.moviedetails.RemoteMovieDetailData
import com.codeinglogs.data.store.moviedetails.MovieDetailDataSoreImpl
import com.codeinglogs.data.store.moviedetails.MovieDetailsDataSore
import com.codeinglogs.domain.repository.MovieDetailRepositoryDomain
import com.codeinglogs.remote.datarepositoryimp.RemoteMovieDetailDataRepositoryImp
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