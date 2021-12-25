package com.codeinglogs.data.domainrepositoryimp

import com.codeinglogs.data.model.home.toDomainHomeDisplay
import com.codeinglogs.data.store.home.HomeDataSore
import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.model.home.HomeDisplay
import com.codeinglogs.domain.repository.HomeRepositoryDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import com.codeinglogs.data.model.State as RemoteState

class HomeRepositoryDomainImp @Inject constructor (private val homeDataSore : HomeDataSore) :
    HomeRepositoryDomain {
    override fun getHome()= flow <State<HomeDisplay>>{
        homeDataSore.getRemoteDataSource().getHome().collect {
            when(it){
                is RemoteState.Failed -> emit(State.failed(it.message))
                is RemoteState.Loading -> {
                    emit(State.loading(homeDataSore.getLocalDataSource().getHomeDisplay().toDomainHomeDisplay()))
                }
                is RemoteState.Success -> {
                    homeDataSore.getLocalDataSource().insertHomeDisplay(it.data)
                    emit(State.success(it.data.toDomainHomeDisplay()))
                }
            }
        }
    }.catch {
        emit(State.failed(it.message?:""))
    }.flowOn(Dispatchers.IO)
}