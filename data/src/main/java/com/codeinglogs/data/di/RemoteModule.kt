package com.codeinglogs.data.di

import com.codeinglogs.data.repousercase.trendingmovies.TrendingMoviesRepositoryImp
import com.codeinglogs.data.store.trendingmovies.TrendingMoviesDataSore
import com.codeinglogs.data.store.trendingmovies.TrendingMoviesRemoteDataSore
import com.codeinglogs.domain.repository.TrendingMoviesRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteModule {

    @Binds
    abstract fun getTrendingMoviesRepository(repo : TrendingMoviesRepositoryImp): TrendingMoviesRepository

    @Binds
    abstract fun getDataSore(dataSore : TrendingMoviesRemoteDataSore): TrendingMoviesDataSore

}