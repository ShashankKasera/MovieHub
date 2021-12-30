package com.codeinglogs.data.domainrepositoryimp

import com.codeinglogs.data.model.person.persondetails.toDomainPersonDetailsDisplay
import com.codeinglogs.data.store.persondetails.PersonDetailsDataSore
import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.model.person.persondetails.PersonDetailsDisplay
import com.codeinglogs.domain.repository.PersonDetailRepositoryDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import com.codeinglogs.data.model.State as RemoteState

class PersonDetailRepositoryDomainImp@Inject constructor (private val personDetailsDataSore : PersonDetailsDataSore):
    PersonDetailRepositoryDomain {
    override fun getPersonDetail(id: String)= flow<State<PersonDetailsDisplay>> {
        personDetailsDataSore.getRemoteDataSource().getPersonDetail(id).collect {

            when(it){
                is RemoteState.Failed -> emit(State.failed(it.message))
                is RemoteState.Loading -> {
                    //emit(State.loading(movieDetailsDataSore.getLocalDataSource().getHomeDisplay().toDomainHomeDisplay()))
                }
                is RemoteState.Success -> {
                    //movieDetailsDataSore.getLocalDataSource().insertHomeDisplay(it.data)
                    emit(State.success(it.data.toDomainPersonDetailsDisplay()))
                }
            }
        }
    }.catch {
        emit(State.failed(it.message?:""))
    }.flowOn(Dispatchers.IO)
}