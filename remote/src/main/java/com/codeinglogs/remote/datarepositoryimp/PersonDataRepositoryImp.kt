package com.codeinglogs.remote.datarepositoryimp

import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.person.PersonList
import com.codeinglogs.data.repository.person.RemotePersonData
import com.codeinglogs.remote.model.person.toDataPersonList
import com.codeinglogs.remote.request.PersonRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PersonDataRepositoryImp @Inject constructor (private val personRequest: PersonRequest) :
    RemotePersonData {
    override fun getPerson(): Flow<State<PersonList>> = flow <State<PersonList>>{
        emit(State.loading())
        val peson = personRequest.getPerson()
        emit(State.success(peson.toDataPersonList()))
    }.catch {
        emit(State.failed(it.message?:""))
    }
}