package com.codeinglogs.data.repository.person

import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.person.personlist.PersonListResponse
import kotlinx.coroutines.flow.Flow

interface RemotePersonData {
    fun getPerson() : Flow<State<PersonListResponse>>
}