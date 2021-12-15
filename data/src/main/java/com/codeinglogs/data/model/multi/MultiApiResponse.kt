package com.codeinglogs.data.model.multi

import com.codeinglogs.data.model.trendingmovies.TrendingMoviesList
import com.codeinglogs.data.model.trendingmovies.toDomainTrendingMoviesList
import com.codeinglogs.data.model.trendingpersonweek.TrendingPersonWeekList
import com.codeinglogs.data.model.trendingpersonweek.toDomainTrendingPersonWeekList
import com.codeinglogs.domain.model.multi.MultiApiResponse as DomainMultiApiResponse

data class MultiApiResponse(
    val person : TrendingPersonWeekList,
    val movie : TrendingMoviesList,
)

fun MultiApiResponse.toDomainMultiApiResponse()=DomainMultiApiResponse(
    person = person.toDomainTrendingPersonWeekList(),
    movie = movie.toDomainTrendingMoviesList(),
)