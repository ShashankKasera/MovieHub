package com.codeinglogs.data.maper

import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.person.PersonList
import com.codeinglogs.data.model.person.toDomainPersonList
import com.codeinglogs.domain.model.State as DomainState


fun State<PersonList>.toDomainState() =
    when(this){
        is State.Loading -> DomainState.loading((this.data)?.toDomainPersonList())
        is State.Failed -> DomainState.failed(this.message)
        is State.Success -> DomainState.success(this.data.toDomainPersonList())
    }