package com.codeinglogs.data.maper

import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.trendingpersonweek.TrendingPersonWeekList
import com.codeinglogs.data.model.trendingpersonweek.toDomainTrendingPersonWeekList
import com.codeinglogs.domain.model.State as Domain

fun  State<TrendingPersonWeekList>.toDomainState() =
    when(this){
        is State.Loading -> Domain.loading((this.data)?.toDomainTrendingPersonWeekList())
        is State.Failed -> Domain.failed(this.message)
        is State.Success -> Domain.success(this.data.toDomainTrendingPersonWeekList())
    }
