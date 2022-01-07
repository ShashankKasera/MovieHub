package com.codeinglogs.remote.model.tvshows.tvshowseasondetails.seasoncredits
import com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasoncredits.TvShowSeasonsCast as DataTvShowSeasonsCast

data class TvShowSeasonsCast(
    val adult: Boolean?,
    val character: String?,
    val credit_id: String?,
    val gender: Int?,
    val id: Int?,
    val known_for_department: String?,
    val name: String?,
    val order: Int?,
    val original_name: String?,
    val popularity: Double?,
    val profile_path: String?
)

fun TvShowSeasonsCast.toDataTvShowSeasonsCast()=DataTvShowSeasonsCast(
    character =character?:"",
    id =id?:0,
    known_for_department =known_for_department?:"",
    name =name?:"",
    profile_path =profile_path?:""
)