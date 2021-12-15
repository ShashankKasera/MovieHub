package com.codeinglogs.domain.repository

import androidx.paging.PagingData
import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.model.trendingmovies.Result
import com.codeinglogs.domain.model.trendingmovies.TrendingMoviesList
import com.codeinglogs.domain.model.trendingpersonweek.ResultTrendingPersonWeekList
import kotlinx.coroutines.flow.Flow

interface TrendingMoviesRepositoryDomain {
    fun getTrendingMovies() : Flow<State<TrendingMoviesList>>
    fun getPagingTrendingMovies() : Flow<PagingData<Result>>
}