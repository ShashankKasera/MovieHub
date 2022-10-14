package com.codeinglogs.core.di

import com.codeinglogs.data.repository.maylist.LocalMyMovieListData
import com.codeinglogs.data.store.maylist.mymovielist.MyMoviesListDataSore
import com.codeinglogs.data.store.maylist.mymovielist.MyMoviesListDataSoreImpl
import com.codeinglogs.domain.repository.maylist.MyMoviesListRepositoryDomain
import com.codeinglogs.local.datarepositoryimp.LocalMyMovieListDataRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MyMovieListModule {

//    @Singleton
//    @Provides
//    fun getMyMovieListRepository(repo : MyMoviesListRepositoryDomainImp): MyMoviesListRepositoryDomain = repo

    @Singleton
    @Provides
    fun getMyMovieListRemoteDataSore(dataSoreImpl : MyMoviesListDataSoreImpl): MyMoviesListDataSore = dataSoreImpl

    @Singleton
    @Provides
    fun getLocalMyMovieListDataRepositoryImp(dataSoreLocal : LocalMyMovieListDataRepositoryImp): LocalMyMovieListData = dataSoreLocal

}

