package com.codeinglogs.data.maper

import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.tvshow.tvshowlist.TvShowsListResponce
import com.codeinglogs.data.model.tvshow.tvshowlist.toDomainTvShowsListResponce
import com.codeinglogs.domain.model.State as Domain
fun State<TvShowsListResponce>.toDomainState() =
    when(this){
        is State.Loading -> Domain.loading((this.data)?.toDomainTvShowsListResponce())
        is State.Failed -> Domain.failed(this.message)
        is State.Success -> Domain.success(this.data.toDomainTvShowsListResponce())
    }