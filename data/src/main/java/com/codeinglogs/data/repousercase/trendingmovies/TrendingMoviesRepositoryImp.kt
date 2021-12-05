package com.codeinglogs.data.repousercase.trendingmovies

import com.codeinglogs.data.maper.toDomainState
import com.codeinglogs.data.store.trendingmovies.TrendingMoviesDataSore
import com.codeinglogs.domain.model.State as DomainState
import com.codeinglogs.domain.model.trendingmovies.TrendingMoviesList
import com.codeinglogs.domain.repository.TrendingMoviesRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class TrendingMoviesRepositoryImp @Inject constructor (private val trendingMoviesDataSore : TrendingMoviesDataSore) : TrendingMoviesRepository {

    override fun getTrendingMovies(): Flow<DomainState<TrendingMoviesList>> {
        return flow {
            trendingMoviesDataSore.getRemoteDataSource().getTrendingMovies().collect {
                emit(it.toDomainState())
            }
        }
    }

}