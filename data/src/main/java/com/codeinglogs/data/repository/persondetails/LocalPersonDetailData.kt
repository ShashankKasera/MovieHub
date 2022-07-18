package com.codeinglogs.data.repository.persondetails

import com.codeinglogs.data.model.person.persondetails.PersonDetailsDisplay

interface LocalPersonDetailData {

    suspend fun getPersonDetail(personId: String): PersonDetailsDisplay
    suspend fun isPersonDetailExist(personId: String): Boolean
    suspend fun insertPersonDetail(PersonDetailsDisplay : PersonDetailsDisplay)

}