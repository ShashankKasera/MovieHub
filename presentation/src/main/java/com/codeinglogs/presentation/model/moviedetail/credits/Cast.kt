package com.codeinglogs.presentation.model.moviedetail.credits

import com.codeinglogs.domain.model.moviedetail.credits.Cast as DomainCast
data class Cast(

    val cast_id: Int,
    val character: String,
    val credit_id: String,
    val id: Int,
    val known_for_department: String,
    val name: String,
    val original_name: String,
    val profile_path: String
)

fun DomainCast.toPresentationCast()= Cast(
    cast_id = cast_id,
    character = character,
    credit_id = credit_id,
    id = id,
    known_for_department = known_for_department,
    name = name,
    original_name = original_name,
    profile_path = profile_path
)