package com.codeinglogs.core.di

import com.codeinglogs.data.domainrepositoryimp.PersonDetailRepositoryDomainImp
import com.codeinglogs.data.repository.persondetails.RemotePersonDetailData
import com.codeinglogs.data.store.persondetails.PersonDetailDataSoreImpl
import com.codeinglogs.data.store.persondetails.PersonDetailsDataSore
import com.codeinglogs.domain.repository.PersonDetailRepositoryDomain
import com.codeinglogs.remote.datarepositoryimp.RemotePersonDetailsDataRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersonDetailModule {

    @Singleton
    @Provides
    fun getPersonDetailRepository(repo : PersonDetailRepositoryDomainImp): PersonDetailRepositoryDomain = repo

    @Singleton
    @Provides
    fun getPersonDetailRemoteDataSore(dataSoreImpl : PersonDetailDataSoreImpl): PersonDetailsDataSore = dataSoreImpl

    @Singleton
    @Provides
    fun getRemotePersonDetailRepositorySore(dataSoreRemote : RemotePersonDetailsDataRepositoryImp): RemotePersonDetailData = dataSoreRemote

}