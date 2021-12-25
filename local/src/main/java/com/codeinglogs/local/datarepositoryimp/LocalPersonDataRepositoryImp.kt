package com.codeinglogs.local.datarepositoryimp

import com.codeinglogs.data.model.person.personlist.Person
import com.codeinglogs.data.repository.person.LocalPersonData
import com.codeinglogs.local.dao.PersonsDao
import javax.inject.Inject

class LocalPersonDataRepositoryImp @Inject constructor (private val personsDao: PersonsDao) :
    LocalPersonData {

    override fun getPerson(): Person {
        TODO("Not yet implemented")
    }
}