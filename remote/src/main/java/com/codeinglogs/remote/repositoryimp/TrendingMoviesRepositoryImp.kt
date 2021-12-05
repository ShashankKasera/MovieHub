package com.codeinglogs.remote.repositoryimp

import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.trendingmovies.TrendingMoviesList
import com.codeinglogs.data.repository.trendingmovies.RemoteTrendingMovies
import com.codeinglogs.remote.model.trendingmovies.toDataTrendingMoviesList
import com.codeinglogs.remote.request.TrendingMoviesRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TrendingMoviesRepositoryImp @Inject constructor (private val trendingMoviesRequest: TrendingMoviesRequest) : RemoteTrendingMovies {
    override fun getTrendingMovies(): Flow<State<TrendingMoviesList>> = flow <State<TrendingMoviesList>>{
        emit(State.loading())
        val trendingMovie = trendingMoviesRequest.getTrendingMovie()
        emit(State.success(trendingMovie.toDataTrendingMoviesList()))
    }.catch {
        emit(State.failed(it.message?:""))
    }

}