package com.codeinglogs.presentation.maper

import com.codeinglogs.domain.model.tvshow.tvshowslist.TvShowsListResponce
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.tvshow.tvshowslist.toPresentationTvShowsListResponce
import com.codeinglogs.domain.model.State as Domain

fun  Domain<TvShowsListResponce>.toPresentationState() =
    when(this){
        is Domain.Loading -> State.loading((this.data)?.toPresentationTvShowsListResponce())
        is Domain.Failed -> State.failed(this.message)
        is Domain.Success -> State.success(this.data.toPresentationTvShowsListResponce())
    }

