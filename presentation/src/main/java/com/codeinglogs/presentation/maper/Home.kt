package com.codeinglogs.presentation.maper

import com.codeinglogs.domain.model.home.HomeDisplay
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.home.toPresentationHomeDisplay
import com.codeinglogs.domain.model.State as Domain

fun Domain<HomeDisplay>.toPresentationState() =
    when(this){
        is Domain.Loading -> State.loading((this.data)?.toPresentationHomeDisplay())
        is Domain.Failed -> State.failed(this.message)
        is Domain.Success -> State.success(this.data.toPresentationHomeDisplay())
    }

