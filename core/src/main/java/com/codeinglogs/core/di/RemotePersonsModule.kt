package com.codeinglogs.core.di

import com.codeinglogs.data.domainrepositoryimp.PersonRepositoryDomainImp
import com.codeinglogs.data.repository.person.RemotePersonData
import com.codeinglogs.data.store.person.PersonDataSore
import com.codeinglogs.data.store.person.PersonDataSoreImpl
import com.codeinglogs.domain.repository.PersonRepositoryDomain
import com.codeinglogs.remote.datarepositoryimp.RemotePersonDataRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemotePersonsModule {



    @Singleton
    @Provides
    fun getPersonRepository(repo : PersonRepositoryDomainImp): PersonRepositoryDomain = repo

    @Singleton
    @Provides
    fun getPersonDataSore(dataSoreImpl : PersonDataSoreImpl): PersonDataSore = dataSoreImpl

    @Singleton
    @Provides
    fun getRemotePersonRepositorySore(dataSoreRemote : RemotePersonDataRepositoryImp): RemotePersonData = dataSoreRemote


}