package com.codeinglogs.domain.model.moviedetail.credits

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