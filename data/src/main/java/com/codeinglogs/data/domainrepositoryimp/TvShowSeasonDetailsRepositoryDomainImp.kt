package com.codeinglogs.data.domainrepositoryimp

import com.codeinglogs.data.model.tvshow.tvshowseasondetails.toDomainTvShowSeasonDetailsDisplay
import com.codeinglogs.data.store.tvshowseasondetails.TvShowSeasonDetailsDataSore
import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.TvShowSeasonDetailsDisplay
import com.codeinglogs.domain.repository.TvShowSeasonDetailsRepositoryDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

import com.codeinglogs.data.model.State as RemoteState

class TvShowSeasonDetailsRepositoryDomainImp @Inject constructor (private val tvShowSeasonDetailsDataSore : TvShowSeasonDetailsDataSore):
    TvShowSeasonDetailsRepositoryDomain {

    override fun getTvShowSeasonDetails(
        id: String,
        season_number: Int
    )= flow <State<TvShowSeasonDetailsDisplay>>{
        tvShowSeasonDetailsDataSore.getRemoteDataSource().getTvShowSeasonDetails(id,season_number).collect {
            when(it){
                is RemoteState.Failed -> emit(State.failed(it.message))
                is RemoteState.Loading -> {
                    //emit(State.loading(tvShowSeasonDetailsDataSore.getLocalDataSource().getHomeDisplay().toDomainHomeDisplay()))
                }
                is RemoteState.Success -> {
                    //tvShowSeasonDetailsDataSore.getLocalDataSource().insertHomeDisplay(it.data)
                    emit(State.success(it.data.toDomainTvShowSeasonDetailsDisplay()))
                }
            }
        }
    }.catch {
        emit(State.failed(it.message?:""))
    }.flowOn(Dispatchers.IO)

}