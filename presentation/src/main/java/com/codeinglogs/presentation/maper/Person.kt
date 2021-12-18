package com.codeinglogs.presentation.maper

import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.person.personlist.toPresentationPersonListResponce
import com.codeinglogs.domain.model.person.personlist.PersonListResponce as PersonListDomain
import com.codeinglogs.domain.model.State as Domain


fun  Domain<PersonListDomain>.toPresentationState() =
    when(this){
        is Domain.Loading -> State.loading((this.data)?.toPresentationPersonListResponce())
        is Domain.Failed -> State.failed(this.message)
        is Domain.Success -> State.success(this.data.toPresentationPersonListResponce())
    }