package com.codeinglogs.data.repository.tvshowseasondetails

import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.tvshow.tvshowseasondetails.TvShowSeasonDetailsDisplay
import kotlinx.coroutines.flow.Flow

interface RemoteTvShowSeasonDetailsData {
    fun getTvShowSeasonDetails(id:String,season_number:Int) : Flow<State<TvShowSeasonDetailsDisplay>>
}