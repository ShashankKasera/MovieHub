package com.codeinglogs.data.domainrepositoryimp

import android.util.Log
import androidx.paging.map
import com.codeinglogs.data.maper.toDomainState
import com.codeinglogs.data.model.movies.movieslist.toDomainMovies
import com.codeinglogs.data.model.movies.movieslist.toDomainMoviesListResponce
import com.codeinglogs.data.store.trendingmovies.TrendingMoviesDataSore
import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.model.movies.movieslist.MoviesListResponce
import com.codeinglogs.domain.repository.TrendingMoviesRepositoryDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import com.codeinglogs.data.model.State as RemoteState

class TrendingMoviesRepositoryDomainImp @Inject constructor (private val trendingMoviesDataSore : TrendingMoviesDataSore) : TrendingMoviesRepositoryDomain {

    override fun getTrendingMovies() = flow <State<MoviesListResponce>>{
        trendingMoviesDataSore.getRemoteDataSource().getTrendingMovies().collect {
            when(it){
                is RemoteState.Failed -> emit(State.failed(it.message))
                is RemoteState.Loading -> {
                    val data = MoviesListResponce(results = trendingMoviesDataSore.getLocalDataSource().getTrendingMovies().toDomainMovies())
                    Log.i("1231viesActivity", "LocalTrendingMovies: $data")
                    emit(State.loading(data))
                    Log.i("1231viesActivity", "LocalTrendingMovies: $data")
                }
                is RemoteState.Success -> {
                    trendingMoviesDataSore.getLocalDataSource().insertTrendingMovies(it.data)
                    emit(State.success(it.data.toDomainMoviesListResponce()))
                }
            }
        }
    }.catch {
        emit(State.failed(it.message?:""))
    }.flowOn(Dispatchers.IO)



    override fun getPagingTrendingMovies()=
        trendingMoviesDataSore.getRemoteDataSource()
            .getPagingTrendingMovies().map { it->it.map { it.toDomainMovies() } }

}