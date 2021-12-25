package com.codeinglogs.core.di

import com.codeinglogs.data.domainrepositoryimp.HomeRepositoryDomainImp
import com.codeinglogs.data.repository.home.LocalHomeData
import com.codeinglogs.data.repository.home.RemoteHomeData
import com.codeinglogs.data.store.home.HomeDataSore
import com.codeinglogs.data.store.home.HomeRemoteDataSore
import com.codeinglogs.domain.repository.HomeRepositoryDomain
import com.codeinglogs.local.datarepositoryimp.LocalHomeDataRepositoryImp
import com.codeinglogs.remote.datarepositoryimp.RemoteHomeDataRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteHomeModule {

    @Singleton
    @Provides
    fun getMultiRepository(repo : HomeRepositoryDomainImp): HomeRepositoryDomain = repo

    @Singleton
    @Provides
    fun getMultiRemoteDataSore(dataSore : HomeRemoteDataSore): HomeDataSore = dataSore

    @Singleton
    @Provides
    fun getRemoteMultiRepositorySore(dataSoreRemote : RemoteHomeDataRepositoryImp): RemoteHomeData = dataSoreRemote


    @Singleton
    @Provides
    fun getLocalHomeDataRepositoryImp(dataSoreRemote : LocalHomeDataRepositoryImp): LocalHomeData = dataSoreRemote

}