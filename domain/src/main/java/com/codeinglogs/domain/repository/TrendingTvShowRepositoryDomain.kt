package com.codeinglogs.domain.repository

import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.model.trendingmovies.TrendingMoviesList
import com.codeinglogs.domain.model.trendingtvshow.TrendingTvShowList
import kotlinx.coroutines.flow.Flow

interface TrendingTvShowRepositoryDomain {

    fun getTrendingTvShow() : Flow<State<TrendingTvShowList>>
}