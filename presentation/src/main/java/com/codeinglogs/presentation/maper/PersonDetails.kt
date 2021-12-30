package com.codeinglogs.presentation.maper

import com.codeinglogs.domain.model.State as Domain
import com.codeinglogs.presentation.model.State
import com.codeinglogs.domain.model.person.persondetails.PersonDetailsDisplay
import com.codeinglogs.presentation.model.person.persondetails.toPresentationPersonDetailsDisplay

fun Domain<PersonDetailsDisplay>.toPresentationState()=
    when(this){
        is Domain.Loading->State.loading((this.data)?.toPresentationPersonDetailsDisplay())
        is Domain.Failed->State.Failed((this.message))
        is Domain.Success->State.Success(this.data.toPresentationPersonDetailsDisplay())
    }