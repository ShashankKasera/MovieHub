package com.codeinglogs.presentation.maper

import com.codeinglogs.domain.model.State as Domain
import com.codeinglogs.presentation.model.State

fun Domain<Boolean>.toPresentationState()=
    when(this){
        is Domain.Loading->State.loading((this.data))
        is Domain.Failed->State.Failed((this.message))
        is Domain.Success->State.Success(this.data)
    }