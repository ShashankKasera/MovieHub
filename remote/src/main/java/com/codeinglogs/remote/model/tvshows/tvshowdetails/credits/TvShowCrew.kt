package com.codeinglogs.remote.model.tvshows.tvshowdetails.credits
import com.codeinglogs.data.model.tvshow.tvshowdetails.credits.TvShowCrew as DataTvShowCrew

data class TvShowCrew(
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
    val profile_path: String?,
)

fun TvShowCrew.toDataTvShowCrew()=DataTvShowCrew(
    id=id?:0,
    known_for_department =known_for_department?:"",
    name =name?:"",
    profile_path =profile_path?:"",
)