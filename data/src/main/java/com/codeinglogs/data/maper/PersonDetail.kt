package com.codeinglogs.data.maper

import com.codeinglogs.domain.model.State as Domain
import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.person.persondetails.PersonDetailsDisplay
import com.codeinglogs.data.model.person.persondetails.toDomainPersonDetailsDisplay

fun State<PersonDetailsDisplay>.toDomainState() =
    when(this){
        is State.Loading -> Domain.loading((this.data)?.toDomainPersonDetailsDisplay())
        is State.Failed -> Domain.failed(this.message)
        is State.Success -> Domain.success(this.data.toDomainPersonDetailsDisplay())
    }
