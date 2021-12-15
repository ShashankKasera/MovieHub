package com.codeinglogs.data.maper

import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.multi.MultiApiResponse
import com.codeinglogs.data.model.multi.toDomainMultiApiResponse
import com.codeinglogs.domain.model.State as Domain

fun State<MultiApiResponse>.toDomainState() =
    when(this){
        is State.Loading -> Domain.loading((this.data)?.toDomainMultiApiResponse())
        is State.Failed -> Domain.failed(this.message)
        is State.Success -> Domain.success(this.data.toDomainMultiApiResponse())
    }
