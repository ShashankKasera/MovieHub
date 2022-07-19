package com.codeinglogs.core.di

import com.codeinglogs.data.domainrepositoryimp.BookmarkMoviesRepositoryDomainImp
import com.codeinglogs.data.repository.bookmark.LocalBookmarkMoviesData
import com.codeinglogs.data.store.bookmark.BookmarkMoviesDataSore
import com.codeinglogs.data.store.bookmark.BookmarkMoviesDataSoreImpl
import com.codeinglogs.domain.repository.BookmarkMoviesRepositoryDomain
import com.codeinglogs.local.datarepositoryimp.LocalBookmarkMovieDataRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BookmarkMoviesModule {

    @Singleton
    @Provides
    fun getBookmarkMoviesRepository(repo : BookmarkMoviesRepositoryDomainImp): BookmarkMoviesRepositoryDomain = repo

    @Singleton
    @Provides
    fun getBookmarkMoviesRemoteDataSore(dataSoreImpl : BookmarkMoviesDataSoreImpl): BookmarkMoviesDataSore = dataSoreImpl

    @Singleton
    @Provides
    fun getLocalBookmarkMoviesDataRepositoryImp(dataSoreRemote : LocalBookmarkMovieDataRepositoryImp): LocalBookmarkMoviesData = dataSoreRemote

}