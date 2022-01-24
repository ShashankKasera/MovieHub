package com.codeinglogs.data.repository.pagingPerson

import androidx.paging.PagingData
import com.codeinglogs.data.model.person.personlist.Person
import kotlinx.coroutines.flow.Flow

interface RemotePersonPagingData {
    fun getPagingPopularPersons(): Flow<PagingData<Person>>
    fun getPagingSearchPersons(personSearch : String): Flow<PagingData<Person>>
}