package com.codeinglogs.data.domainrepositoryimp

import com.codeinglogs.data.maper.toDomainState
import com.codeinglogs.data.store.person.PersonDataSore
import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.model.person.personlist.PersonListResponse
import com.codeinglogs.domain.repository.PersonRepositoryDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PersonRepositoryDomainImp @Inject constructor (private val PersonDataSore : PersonDataSore) :
    PersonRepositoryDomain {

    override fun getPerson(): Flow<State<PersonListResponse>> {
        return flow {
            PersonDataSore.getRemoteDataSource().getPerson().collect {
                emit(it.toDomainState())
            }
        }
    }

}