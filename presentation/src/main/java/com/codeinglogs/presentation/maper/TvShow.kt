package com.codeinglogs.presentation.maper

import com.codeinglogs.domain.model.tvshow.tvshowslist.TvShowsListResponse
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.tvshow.tvshowslist.toPresentationTvShowsListResponse
import com.codeinglogs.domain.model.State as Domain

fun  Domain<TvShowsListResponse>.toPresentationState() =
    when(this){
        is Domain.Loading -> State.loading((this.data)?.toPresentationTvShowsListResponse())
        is Domain.Failed -> State.failed(this.message)
        is Domain.Success -> State.success(this.data.toPresentationTvShowsListResponse())
    }

