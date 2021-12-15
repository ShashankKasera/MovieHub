package com.codeinglogs.presentation.model.multi

import com.codeinglogs.domain.model.trendingmovies.TrendingMoviesList
import com.codeinglogs.domain.model.trendingpersonweek.TrendingPersonWeekList
import com.codeinglogs.domain.model.multi.MultiApiResponse as DomainMultiApiResponse

data class MultiApiResponse(
    val person : TrendingPersonWeekList,
    val movie : TrendingMoviesList,
)

fun DomainMultiApiResponse.toPresentationMultiApiResponse()=MultiApiResponse(
    person=person,
    movie=movie
)