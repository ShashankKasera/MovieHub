package com.codeinglogs.data.domainrepositoryimp

import com.codeinglogs.data.maper.toDomainState
import com.codeinglogs.data.store.home.HomeDataSore
import com.codeinglogs.domain.repository.HomeRepositoryDomain
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HomeRepositoryDomainImp @Inject constructor (private val homeDataSore : HomeDataSore) :
    HomeRepositoryDomain {
    override fun getHome()=homeDataSore.getRemoteDataSource().getHome().map { it.toDomainState() }

}