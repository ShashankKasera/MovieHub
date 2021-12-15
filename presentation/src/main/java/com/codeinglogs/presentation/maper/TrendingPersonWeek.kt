package com.codeinglogs.presentation.maper

import com.codeinglogs.presentation.model.State

import com.codeinglogs.domain.model.trendingpersonweek.TrendingPersonWeekList as TrendingPersonWeekListDomain
import com.codeinglogs.presentation.model.trendingpersonweek.toPresentationTrendingPersonWeekList
import com.codeinglogs.domain.model.State as Domain

fun Domain<TrendingPersonWeekListDomain>.toPresentationState() =
    when(this){
        is Domain.Loading ->State.loading((this.data)?.toPresentationTrendingPersonWeekList())
        is Domain.Failed -> State.failed(this.message)
        is Domain.Success -> State.success(this.data.toPresentationTrendingPersonWeekList())
    }