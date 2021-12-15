package com.codeinglogs.remote.datarepositoryimp

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.trendingmovies.Result
import com.codeinglogs.data.model.trendingmovies.TrendingMoviesList
import com.codeinglogs.data.repository.trendingmovies.RemoteTrendingMoviesData
import com.codeinglogs.remote.model.trendingmovies.toDataTrendingMoviesList
import com.codeinglogs.remote.pagingsource.TrendingMoviePagingSource
import com.codeinglogs.remote.request.TrendingMoviesRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TrendingMoviesDataRepositoryImp @Inject constructor (
    private val trendingMoviesRequest: TrendingMoviesRequest,
    private val trendingMoviePagingSource: TrendingMoviePagingSource
) :
    RemoteTrendingMoviesData {
    override fun getTrendingMovies(): Flow<State<TrendingMoviesList>> = flow <State<TrendingMoviesList>>{
        emit(State.loading())
        val trendingMovie = trendingMoviesRequest.getTrendingMovie()
        emit(State.success(trendingMovie.toDataTrendingMoviesList()))
    }.catch {
        emit(State.failed(it.message?:""))
    }

    override fun getPagingTrendingMovies(): Flow<PagingData<Result>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { trendingMoviePagingSource }
        ).flow
    }

}