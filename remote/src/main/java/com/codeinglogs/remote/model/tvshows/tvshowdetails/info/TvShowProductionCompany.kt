package com.codeinglogs.remote.model.tvshows.tvshowdetails.info
import com.codeinglogs.data.model.tvshow.tvshowdetails.info.TvShowProductionCompany as DataTvShowProductionCompany

data class TvShowProductionCompany(
    val id: Int,
    val logo_path: String,
    val name: String,
    val origin_country: String
)
fun TvShowProductionCompany.toDataTvShowProductionCompany()=DataTvShowProductionCompany(
    id=id,
    name=name
)