package com.codeinglogs.data.repository.persondetails

import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.person.persondetails.PersonDetailsDisplay
import kotlinx.coroutines.flow.Flow

interface RemotePersonDetailData {

    fun getPersonDetail(id:String) : Flow<State<PersonDetailsDisplay>>
}