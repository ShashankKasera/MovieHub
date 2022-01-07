package com.codeinglogs.domain.repository

import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.TvShowSeasonDetailsDisplay
import kotlinx.coroutines.flow.Flow

interface TvShowSeasonDetailsRepositoryDomain {

    fun getTvShowSeasonDetails(id:String,season_number:Int): Flow<State<TvShowSeasonDetailsDisplay>>
}