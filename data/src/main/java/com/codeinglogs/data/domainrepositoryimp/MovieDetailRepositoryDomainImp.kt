package com.codeinglogs.data.domainrepositoryimp

import com.codeinglogs.data.model.movies.moviedetail.toDomainMovieDetailsDisplay
import com.codeinglogs.domain.model.movies.moviedetail.MovieDetailsDisplay
import com.codeinglogs.data.store.moviedetails.MovieDetailsDataSore
import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.repository.MovieDetailRepositoryDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import com.codeinglogs.data.model.State as RemoteState

class MovieDetailRepositoryDomainImp @Inject constructor (private val movieDetailsDataSore : MovieDetailsDataSore):
    MovieDetailRepositoryDomain {
    override fun getMovieDetail(id:String)=flow <State<MovieDetailsDisplay>>{
        movieDetailsDataSore.getRemoteDataSource().getMovieDetail(id).collect {
            when(it){
                is RemoteState.Failed -> emit(State.failed(it.message))
                is RemoteState.Loading -> {
                    //emit(State.loading(movieDetailsDataSore.getLocalDataSource().getHomeDisplay().toDomainHomeDisplay()))
                }
                is RemoteState.Success -> {
                    //movieDetailsDataSore.getLocalDataSource().insertHomeDisplay(it.data)
                    emit(State.success(it.data.toDomainMovieDetailsDisplay()))
                }
            }
        }
    }.catch {
        emit(State.failed(it.message?:""))
    }.flowOn(Dispatchers.IO)
}