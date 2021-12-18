package com.codeinglogs.data.maper

import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.person.personlist.PersonListResponce
import com.codeinglogs.data.model.person.personlist.toDomainPersonListResponce
import com.codeinglogs.domain.model.State as DomainState


fun State<PersonListResponce>.toDomainState() =
    when(this){
        is State.Loading -> DomainState.loading((this.data)?.toDomainPersonListResponce())
        is State.Failed -> DomainState.failed(this.message)
        is State.Success -> DomainState.success(this.data.toDomainPersonListResponce())
    }