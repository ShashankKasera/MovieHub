package com.codeinglogs.domain.usecase

import com.codeinglogs.domain.model.person.personenum.PersonType
import com.codeinglogs.domain.repository.PersonPagingRepositoryDomain
import javax.inject.Inject

class GetPersonPaging @Inject constructor(private val personPagingRepositoryDomain: PersonPagingRepositoryDomain) {
    operator fun invoke(personType: PersonType, personSearch: String) = personPagingRepositoryDomain.getPagingPerson(personType,personSearch)
}