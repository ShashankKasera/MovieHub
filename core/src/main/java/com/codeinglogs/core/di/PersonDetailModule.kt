package com.codeinglogs.core.di

import com.codeinglogs.data.domainrepositoryimp.HomeRepositoryDomainImp
import com.codeinglogs.data.domainrepositoryimp.MovieDetailRepositoryDomainImp
import com.codeinglogs.data.domainrepositoryimp.PersonDetailRepositoryDomainImp
import com.codeinglogs.data.repository.moviedetails.RemoteMovieDetailData
import com.codeinglogs.data.repository.person.LocalPersonData
import com.codeinglogs.data.repository.person.RemotePersonData
import com.codeinglogs.data.repository.persondetails.RemotePersonDetailData
import com.codeinglogs.data.store.home.HomeDataSore
import com.codeinglogs.data.store.home.HomeRemoteDataSore
import com.codeinglogs.data.store.moviedetails.MovieDetailDataSoreImpl
import com.codeinglogs.data.store.moviedetails.MovieDetailsDataSore
import com.codeinglogs.data.store.persondetails.PersonDetailDataSoreImpl
import com.codeinglogs.data.store.persondetails.PersonDetailsDataSore
import com.codeinglogs.domain.repository.HomeRepositoryDomain
import com.codeinglogs.domain.repository.MovieDetailRepositoryDomain
import com.codeinglogs.domain.repository.PersonDetailRepositoryDomain
import com.codeinglogs.local.datarepositoryimp.LocalPersonDataRepositoryImp
import com.codeinglogs.remote.datarepositoryimp.RemoteMovieDetailDataRepositoryImp
import com.codeinglogs.remote.datarepositoryimp.RemotePersonDataRepositoryImp
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