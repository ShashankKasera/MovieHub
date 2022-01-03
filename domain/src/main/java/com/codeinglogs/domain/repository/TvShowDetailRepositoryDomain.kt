package com.codeinglogs.domain.repository
import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.model.tvshow.tvshowdetails.TvShowDetailsDisplay
import kotlinx.coroutines.flow.Flow
interface TvShowDetailRepositoryDomain {

    fun getTvShowDetail(id:String): Flow<State<TvShowDetailsDisplay>>
}