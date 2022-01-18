package com.codeinglogs.domain.repository

import androidx.paging.PagingData
import com.codeinglogs.domain.model.person.personlist.Person
import kotlinx.coroutines.flow.Flow

interface PersonPagingRepositoryDomain {
    fun getPagingPerson(): Flow<PagingData<Person>>
}