package com.codeinglogs.core.di

import com.codeinglogs.data.repository.maylist.LocalMyMovieListDetailsData
import com.codeinglogs.data.store.maylist.mymovielist.MyMoviesListDataSore
import com.codeinglogs.data.store.maylist.mymovielist.MyMoviesListDataSoreImpl
import com.codeinglogs.data.store.maylist.mymovielistdetails.MyMoviesListDetailsDataSore
import com.codeinglogs.data.store.maylist.mymovielistdetails.MyMoviesListDetailsDataSoreImpl
import com.codeinglogs.domain.repository.maylist.MyMoviesListDetailsRepositoryDomain
import com.codeinglogs.domain.repository.maylist.MyMoviesListRepositoryDomain
import com.codeinglogs.local.datarepositoryimp.LocalMyMovieListDetailsDataRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MyMovieListDetailsModule {

//    @Singleton
//    @Provides
//    fun getMyMovieListDetailsRepository(repo : MyMoviesListDetailsRepositoryDomainImp): MyMoviesListDetailsRepositoryDomain = repo

    @Singleton
    @Provides
    fun getMyMovieListDetailsRemoteDataSore(dataSoreImpl : MyMoviesListDetailsDataSoreImpl): MyMoviesListDetailsDataSore = dataSoreImpl

    @Singleton
    @Provides
    fun getLocalMyMovieListDetailsDataRepositoryImp(dataSoreLocal : LocalMyMovieListDetailsDataRepositoryImp): LocalMyMovieListDetailsData = dataSoreLocal

}

