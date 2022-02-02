package com.codeinglogs.core.di

import com.codeinglogs.data.domainrepositoryimp.PersonRepositoryDomainImp
import com.codeinglogs.data.repository.person.LocalPersonData
import com.codeinglogs.data.repository.person.RemotePersonData
import com.codeinglogs.data.store.person.PersonDataSore
import com.codeinglogs.data.store.person.PersonDataSoreImpl
import com.codeinglogs.domain.repository.PersonRepositoryDomain
import com.codeinglogs.local.dao.PersonsDao
import com.codeinglogs.local.datarepositoryimp.LocalPersonDataRepositoryImp
import com.codeinglogs.local.db.MovieHubDatabase
import com.codeinglogs.remote.datarepositoryimp.RemotePersonDataRepositoryImp
import com.codeinglogs.remote.request.PersonRequest
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
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

    @Singleton
    @Provides
    fun getLocalPersonData(dataSoreRemote : LocalPersonDataRepositoryImp): LocalPersonData = dataSoreRemote

}