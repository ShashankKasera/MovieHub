package com.codeinglogs.data.repository.person

import com.codeinglogs.data.model.person.personlist.Person

interface LocalPersonData {
    fun getPerson() : Person
}