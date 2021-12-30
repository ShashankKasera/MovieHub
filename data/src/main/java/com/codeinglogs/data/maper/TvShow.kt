package com.codeinglogs.data.maper

import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.tvshow.tvshowlist.TvShowsListResponse
import com.codeinglogs.data.model.tvshow.tvshowlist.toDomainTvShowsListResponse
import com.codeinglogs.domain.model.State as Domain
fun State<TvShowsListResponse>.toDomainState() =
    when(this){
        is State.Loading -> Domain.loading((this.data)?.toDomainTvShowsListResponse())
        is State.Failed -> Domain.failed(this.message)
        is State.Success -> Domain.success(this.data.toDomainTvShowsListResponse())
    }