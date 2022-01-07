package com.codeinglogs.data.maper

import com.codeinglogs.domain.model.State as Domain
import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.tvshow.tvshowseasondetails.TvShowSeasonDetailsDisplay
import com.codeinglogs.data.model.tvshow.tvshowseasondetails.toDomainTvShowSeasonDetailsDisplay

fun State<TvShowSeasonDetailsDisplay>.toDomainState() =
    when(this){
        is State.Loading -> Domain.loading((this.data)?.toDomainTvShowSeasonDetailsDisplay())
        is State.Failed -> Domain.failed(this.message)
        is State.Success -> Domain.success(this.data.toDomainTvShowSeasonDetailsDisplay())
    }
