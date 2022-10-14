package com.codeinglogs.core.di

import com.codeinglogs.data.domainrepositoryimp.bookmark.BookmarkTvShowsRepositoryDomainImp
import com.codeinglogs.data.repository.bookmark.LocalBookmarkTvShowsData
import com.codeinglogs.data.store.bookmark.bookmarktvshows.BookmarkTvShowsDataSore
import com.codeinglogs.data.store.bookmark.bookmarktvshows.BookmarkTvShowsDataSoreImpl
import com.codeinglogs.domain.repository.bookmark.BookmarkTvShowsRepositoryDomain
import com.codeinglogs.local.datarepositoryimp.LocalBookmarkTvShowsDataRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BookmarkTvShowsModule {
    @Singleton
    @Provides
    fun getBookmarkTvShowsRepository(repo : BookmarkTvShowsRepositoryDomainImp): BookmarkTvShowsRepositoryDomain = repo

    @Singleton
    @Provides
    fun getBookmarkTvShowsRemoteDataSore(dataSoreImpl : BookmarkTvShowsDataSoreImpl): BookmarkTvShowsDataSore = dataSoreImpl

    @Singleton
    @Provides
    fun getLocalBookmarkTvShowsDataRepositoryImp(dataSoreLocal : LocalBookmarkTvShowsDataRepositoryImp): LocalBookmarkTvShowsData = dataSoreLocal

}