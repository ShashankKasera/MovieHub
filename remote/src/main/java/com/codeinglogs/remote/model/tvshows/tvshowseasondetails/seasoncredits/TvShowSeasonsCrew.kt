package com.codeinglogs.remote.model.tvshows.tvshowseasondetails.seasoncredits
import com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasoncredits.TvShowSeasonsCrew as DataTvShowSeasonsCrew

data class TvShowSeasonsCrew(
    val adult: Boolean?,
    val credit_id: String?,
    val department: String?,
    val gender: Int?,
    val id: Int?,
    val job: String?,
    val known_for_department: String?,
    val name: String?,
    val original_name: String?,
    val popularity: Double?,
    val profile_path: String?
)

fun TvShowSeasonsCrew.toDataTvShowSeasonsCrew()=DataTvShowSeasonsCrew(
    id =id?:0,
    known_for_department =known_for_department?:"",
    name =name?:"",
    profile_path =profile_path?:""
)