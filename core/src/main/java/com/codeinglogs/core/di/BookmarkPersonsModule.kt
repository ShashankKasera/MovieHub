package com.codeinglogs.core.di

import com.codeinglogs.data.domainrepositoryimp.bookmark.BookmarkPersonsRepositoryDomainImp
import com.codeinglogs.data.repository.bookmark.LocalBookmarkPersonsData
import com.codeinglogs.data.store.bookmark.bookmarkpersons.BookmarkPersonsDataSore
import com.codeinglogs.data.store.bookmark.bookmarkpersons.BookmarkPersonsDataSoreImpl
import com.codeinglogs.domain.repository.bookmark.BookmarkPersonsRepositoryDomain
import com.codeinglogs.local.datarepositoryimp.LocalBookmarkPersonsDataRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BookmarkPersonsModule {

    @Singleton
    @Provides
    fun getBookmarkPersonsRepository(repo : BookmarkPersonsRepositoryDomainImp): BookmarkPersonsRepositoryDomain = repo

    @Singleton
    @Provides
    fun getBookmarkPersonsRemoteDataSore(dataSoreImpl : BookmarkPersonsDataSoreImpl): BookmarkPersonsDataSore = dataSoreImpl

    @Singleton
    @Provides
    fun getLocalBookmarkPersonsDataRepositoryImp(dataSoreLocal : LocalBookmarkPersonsDataRepositoryImp): LocalBookmarkPersonsData = dataSoreLocal

}