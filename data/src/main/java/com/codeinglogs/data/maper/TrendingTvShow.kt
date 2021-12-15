package com.codeinglogs.data.maper

import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.trendingtvshow.TrendingTvShowList
import com.codeinglogs.data.model.trendingtvshow.toDomainTrendingTvShowList

fun State<TrendingTvShowList>.toDomainState() =
    when(this){
        is State.Loading -> com.codeinglogs.domain.model.State.loading((this.data)?.toDomainTrendingTvShowList())
        is State.Failed -> com.codeinglogs.domain.model.State.failed(this.message)
        is State.Success -> com.codeinglogs.domain.model.State.success(this.data.toDomainTrendingTvShowList())
    }