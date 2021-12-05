package com.codeinglogs.data.maper

import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.trendingmovies.TrendingMoviesList
import com.codeinglogs.data.model.trendingmovies.toDomainTrendingMoviesList
import com.codeinglogs.domain.model.State as Domain

fun  State<TrendingMoviesList>.toDomainState() =
     when(this){
        is State.Loading -> Domain.loading((this.data)?.toDomainTrendingMoviesList())
        is State.Failed -> Domain.failed(this.message)
        is State.Success -> Domain.success(this.data.toDomainTrendingMoviesList())
    }
