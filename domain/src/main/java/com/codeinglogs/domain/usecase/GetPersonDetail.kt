package com.codeinglogs.domain.usecase

import com.codeinglogs.domain.repository.PersonDetailRepositoryDomain
import javax.inject.Inject

class GetPersonDetail@Inject constructor(private val personDetailRepositoryDomain: PersonDetailRepositoryDomain) {

    operator fun invoke(id:String) = personDetailRepositoryDomain.getPersonDetail(id)
}