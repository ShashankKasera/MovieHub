package com.codeinglogs.data.maper

import com.codeinglogs.domain.model.State as Domain
import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.tvshow.tvshowdetails.TvShowDetailsDisplay
import com.codeinglogs.data.model.tvshow.tvshowdetails.toDomainTvShowDetails

fun State<TvShowDetailsDisplay>.toDomainState() =
    when(this){
        is State.Loading -> Domain.loading((this.data)?.toDomainTvShowDetails())
        is State.Failed -> Domain.failed(this.message)
        is State.Success -> Domain.success(this.data.toDomainTvShowDetails())
    }
