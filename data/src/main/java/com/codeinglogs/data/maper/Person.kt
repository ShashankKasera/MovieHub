package com.codeinglogs.data.maper

import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.person.personlist.PersonListResponse
import com.codeinglogs.data.model.person.personlist.toDomainPersonListResponse
import com.codeinglogs.domain.model.State as DomainState


fun State<PersonListResponse>.toDomainState() =
    when(this){
        is State.Loading -> DomainState.loading((this.data)?.toDomainPersonListResponse())
        is State.Failed -> DomainState.failed(this.message)
        is State.Success -> DomainState.success(this.data.toDomainPersonListResponse())
    }