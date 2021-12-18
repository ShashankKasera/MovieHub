package com.codeinglogs.data.maper

import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.home.HomeDisplay
import com.codeinglogs.data.model.home.toDomainHomeDisplay
import com.codeinglogs.domain.model.State as Domain

fun State<HomeDisplay>.toDomainState() =
    when(this){
        is State.Loading -> Domain.loading((this.data)?.toDomainHomeDisplay())
        is State.Failed -> Domain.failed(this.message)
        is State.Success -> Domain.success(this.data.toDomainHomeDisplay())
    }
