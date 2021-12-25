package com.codeinglogs.presentation.model.moviedetail.credits

import com.codeinglogs.domain.model.moviedetail.credits.Crew as DomainCrew
data class Crew(

    val credit_id: String,
    val department: String,
    val id: Int,
    val known_for_department: String,
    val name: String,
    val original_name: String,
    val profile_path: String
)

fun DomainCrew.toPresentationCrew()= Crew(
    credit_id = credit_id ,
    department = department ,
    id = id ,
    known_for_department = known_for_department,
    name = name ,
    original_name = original_name ,
    profile_path = profile_path
)