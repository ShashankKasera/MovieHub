package com.codeinglogs.domain.repository

import com.codeinglogs.domain.model.person.PersonList
import com.codeinglogs.domain.model.State
import kotlinx.coroutines.flow.Flow

interface PersonRepositoryDomain {
    fun getPerson() : Flow<State<PersonList>>
}