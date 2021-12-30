package com.codeinglogs.domain.repository

import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.model.person.persondetails.PersonDetailsDisplay
import kotlinx.coroutines.flow.Flow

interface PersonDetailRepositoryDomain {
    fun getPersonDetail(id:String): Flow<State<PersonDetailsDisplay>>
}