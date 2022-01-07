package com.codeinglogs.presentation.maper


import com.codeinglogs.domain.model.State as Domain
import com.codeinglogs.presentation.model.State
import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.TvShowSeasonDetailsDisplay
import com.codeinglogs.presentation.model.tvshow.tvshowseasondetails.toPresentationTvShowSeasonDetailsDisplay

fun Domain<TvShowSeasonDetailsDisplay>.toPresentationState()=
    when(this) {
        is Domain.Loading -> State.loading((this.data)?.toPresentationTvShowSeasonDetailsDisplay())
        is Domain.Failed -> State.Failed((this.message))
        is Domain.Success -> State.Success(this.data.toPresentationTvShowSeasonDetailsDisplay())
    }
