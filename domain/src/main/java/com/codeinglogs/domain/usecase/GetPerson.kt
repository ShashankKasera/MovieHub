package com.codeinglogs.domain.usecase

import com.codeinglogs.domain.repository.PersonRepositoryDomain
import javax.inject.Inject

class GetPerson @Inject constructor(private val personRepositoryDomain: PersonRepositoryDomain){

    operator fun invoke() = personRepositoryDomain.getPerson()
}