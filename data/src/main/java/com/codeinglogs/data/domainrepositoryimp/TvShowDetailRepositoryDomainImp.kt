package com.codeinglogs.data.domainrepositoryimp

import com.codeinglogs.data.model.movies.moviedetail.toDomainMovieDetailsDisplay
import com.codeinglogs.data.model.tvshow.tvshowdetails.toDomainTvShowDetails
import com.codeinglogs.data.store.tvshowdetails.TvShowDetailsDataSore
import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.model.tvshow.tvshowdetails.TvShowDetailsDisplay
import com.codeinglogs.domain.repository.TvShowDetailRepositoryDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import com.codeinglogs.data.model.State as RemoteState

class TvShowDetailRepositoryDomainImp @Inject constructor (private val tvShowDetailsDataSore : TvShowDetailsDataSore):
    TvShowDetailRepositoryDomain {
    override fun getTvShowDetail(id:String)=flow <State<TvShowDetailsDisplay>>{
        tvShowDetailsDataSore.getRemoteDataSource().getTvShowDetail(id).collect {
            when(it){
                is RemoteState.Failed -> {
                    if(!tvShowDetailsDataSore.getLocalDataSource().isTvShowDetailExist(id)){
                        emit(State.failed(it.message?:""))
                    }
                }
                is RemoteState.Loading -> {
                    if(tvShowDetailsDataSore.getLocalDataSource().isTvShowDetailExist(id)){
                        emit(State.loading(tvShowDetailsDataSore.getLocalDataSource().getTvShowDetail(id).toDomainTvShowDetails()))
                    }
                    else{
                        emit(State.loading())
                    }
                }
                is RemoteState.Success -> {
                    it.data.Bookmark=tvShowDetailsDataSore.getLocalDataSource().isBookmarkTvShowsIsExist(id.toLong())
                    tvShowDetailsDataSore.getLocalDataSource().insertTvShowDetail(it.data)
                    emit(State.success(it.data.toDomainTvShowDetails()))
                }
            }
        }
    }.catch {
        if(!tvShowDetailsDataSore.getLocalDataSource().isTvShowDetailExist(id)){
            emit(State.failed(it.message?:""))
        }
    }.flowOn(Dispatchers.IO)
}