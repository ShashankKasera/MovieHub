package com.codeinglogs.data.repository.trendingmovies

import androidx.paging.PagingData
import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.trendingmovies.Result
import com.codeinglogs.data.model.trendingmovies.TrendingMoviesList
import com.codeinglogs.data.model.trendingpersonweek.ResultTrendingPersonWeekList
import kotlinx.coroutines.flow.Flow

interface RemoteTrendingMoviesData {
    fun getTrendingMovies() : Flow<State<TrendingMoviesList>>
    fun getPagingTrendingMovies() : Flow<PagingData<Result>>
}