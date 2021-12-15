package com.codeinglogs.presentation.maper

import com.codeinglogs.domain.model.trendingmovies.TrendingMoviesList
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.trendingmovies.toPresentationTrendingMoviesList
import com.codeinglogs.domain.model.State as Domain

fun  Domain<TrendingMoviesList>.toPresentationState() =
     when(this){
        is Domain.Loading -> State.loading((this.data)?.toPresentationTrendingMoviesList())
        is Domain.Failed -> State.failed(this.message)
        is Domain.Success -> State.success(this.data.toPresentationTrendingMoviesList())
    }

