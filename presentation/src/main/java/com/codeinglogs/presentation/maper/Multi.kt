package com.codeinglogs.presentation.maper

import com.codeinglogs.presentation.model.State
import com.codeinglogs.domain.model.multi.MultiApiResponse
import com.codeinglogs.presentation.model.multi.toPresentationMultiApiResponse
import com.codeinglogs.domain.model.State as Domain

fun Domain<MultiApiResponse>.toPresentationState() =
    when(this){
        is Domain.Loading -> State.loading((this.data)?.toPresentationMultiApiResponse())
        is Domain.Failed -> State.failed(this.message)
        is Domain.Success -> State.success(this.data.toPresentationMultiApiResponse())
    }

