package com.codeinglogs.remote.model.moviedetail.credits

import com.codeinglogs.data.model.moviedetail.credits.Cast as DataCast
data class Cast(
    val adult: Boolean?,
    val cast_id: Int?,
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

fun Cast.toDataCast()=DataCast(
    cast_id=cast_id?:0,
    character=character?:"",
    credit_id=credit_id?:"",
    id=id?:0,
    known_for_department=known_for_department?:"",
    name=name?:"",
    original_name=original_name?:"",
    profile_path=profile_path?:""
)