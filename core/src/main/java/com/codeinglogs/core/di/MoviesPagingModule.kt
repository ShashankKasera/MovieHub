package com.codeinglogs.core.di

import com.codeinglogs.data.domainrepositoryimp.MoviesPagingRepositoryDomainImp
import com.codeinglogs.data.repository.pagingmovies.RemoteMoviesPagingData
import com.codeinglogs.data.store.pagingmovies.MoviesPagingDataSore
import com.codeinglogs.data.store.pagingmovies.MoviesPagingDataSoreImpl
import com.codeinglogs.domain.repository.MoviesPagingRepositoryDomain
import com.codeinglogs.remote.datarepositoryimp.RemoteMoviesPagingDataRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesPagingModule {


    @Singleton
    @Provides
    fun getTrendingMoviesRepository(repo : MoviesPagingRepositoryDomainImp): MoviesPagingRepositoryDomain = repo

    @Singleton
    @Provides
    fun getTrendingMoviesRemoteDataSore(dataSoreImpl : MoviesPagingDataSoreImpl): MoviesPagingDataSore = dataSoreImpl

    @Singleton
    @Provides
    fun getRemoteTrendingMoviesRepositorySore(dataSoreRemote : RemoteMoviesPagingDataRepositoryImp): RemoteMoviesPagingData = dataSoreRemote


}