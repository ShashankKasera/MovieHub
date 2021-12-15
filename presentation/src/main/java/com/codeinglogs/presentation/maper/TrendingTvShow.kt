package com.codeinglogs.presentation.maper

import com.codeinglogs.domain.model.trendingtvshow.TrendingTvShowList
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.trendingpersonweek.toPresentationTrendingPersonWeekList
import com.codeinglogs.presentation.model.trendingtvshow.toPresentationTrendingTvShowList
import com.codeinglogs.domain.model.State as Domain

fun  Domain<TrendingTvShowList>.toPresentationState() =
    when(this){
        is Domain.Loading -> State.loading((this.data)?.toPresentationTrendingTvShowList())
        is Domain.Failed -> State.failed(this.message)
        is Domain.Success -> State.success(this.data.toPresentationTrendingTvShowList())
    }

