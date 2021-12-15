package com.codeinglogs.domain.model.multi

import com.codeinglogs.domain.model.trendingmovies.TrendingMoviesList
import com.codeinglogs.domain.model.trendingpersonweek.TrendingPersonWeekList

data class MultiApiResponse(
    val person : TrendingPersonWeekList,
    val movie : TrendingMoviesList,
)