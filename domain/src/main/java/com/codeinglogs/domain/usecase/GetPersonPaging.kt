package com.codeinglogs.domain.usecase

import com.codeinglogs.domain.repository.PersonPagingRepositoryDomain
import javax.inject.Inject

class GetPersonPaging @Inject constructor(private val personPagingRepositoryDomain: PersonPagingRepositoryDomain) {
    operator fun invoke() = personPagingRepositoryDomain.getPagingPerson()
}