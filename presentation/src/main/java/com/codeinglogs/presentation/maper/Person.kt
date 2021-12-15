package com.codeinglogs.presentation.maper

import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.person.toPresentationPersonList
import com.codeinglogs.domain.model.person.PersonList as PersonListDomain
import com.codeinglogs.domain.model.State as Domain


fun  Domain<PersonListDomain>.toPresentationState() =
    when(this){
        is Domain.Loading -> State.loading((this.data)?.toPresentationPersonList())
        is Domain.Failed -> State.failed(this.message)
        is Domain.Success -> State.success(this.data.toPresentationPersonList())
    }