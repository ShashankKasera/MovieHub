package com.codeinglogs.domain.model.moviedetail.credits

data class Crew(

    val credit_id: String,
    val department: String,
    val id: Int,
    val known_for_department: String,
    val name: String,
    val original_name: String,
    val profile_path: String
)

