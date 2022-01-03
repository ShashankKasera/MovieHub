package com.codeinglogs.data.domainrepositoryimp

import com.codeinglogs.data.model.tvshow.tvshowdetails.toDomainTvShowDetails
import com.codeinglogs.data.store.tvshowdetails.TvShowDetailsDataSore
import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.model.tvshow.tvshowdetails.TvShowDetailsDisplay
import com.codeinglogs.domain.repository.TvShowDetailRepositoryDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import com.codeinglogs.data.model.State as RemoteState

class TvShowDetailRepositoryDomainImp @Inject constructor (private val movieDetailsDataSore : TvShowDetailsDataSore):
    TvShowDetailRepositoryDomain {
    override fun getTvShowDetail(id:String)=flow <State<TvShowDetailsDisplay>>{
        movieDetailsDataSore.getRemoteDataSource().getTvShowDetail(id).collect {
            when(it){
                is RemoteState.Failed -> emit(State.failed(it.message))
                is RemoteState.Loading -> {
                    //emit(State.loading(movieDetailsDataSore.getLocalDataSource().getHomeDisplay().toDomainHomeDisplay()))
                }
                is RemoteState.Success -> {
                    //movieDetailsDataSore.getLocalDataSource().insertHomeDisplay(it.data)
                    emit(State.success(it.data.toDomainTvShowDetails()))
                }
            }
        }
    }.catch {
        emit(State.failed(it.message?:""))
    }.flowOn(Dispatchers.IO)
}