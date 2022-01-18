package com.codeinglogs.core.di

import com.codeinglogs.data.domainrepositoryimp.PersonPagingRepositoryDomainImp
import com.codeinglogs.data.repository.pagingPerson.RemotePersonPagingData
import com.codeinglogs.data.store.pagingperson.PersonPagingDataSore
import com.codeinglogs.data.store.pagingperson.PersonPagingDataSoreImpl
import com.codeinglogs.domain.repository.PersonPagingRepositoryDomain
import com.codeinglogs.remote.datarepositoryimp.RemotePersonPagingDataRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersonPagingModule {


    @Singleton
    @Provides
    fun getPersonPagingRepository(repo : PersonPagingRepositoryDomainImp): PersonPagingRepositoryDomain = repo

    @Singleton
    @Provides
    fun getPersonPagingRemoteDataSore(dataSoreImpl : PersonPagingDataSoreImpl): PersonPagingDataSore = dataSoreImpl

    @Singleton
    @Provides
    fun getRemotePersonPagingRepositorySore(dataSoreRemote : RemotePersonPagingDataRepositoryImp): RemotePersonPagingData = dataSoreRemote


}