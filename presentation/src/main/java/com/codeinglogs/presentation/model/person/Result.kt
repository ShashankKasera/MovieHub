package com.codeinglogs.presentation.model.person

import com.codeinglogs.domain.model.person.Result as DomainResult
import com.codeinglogs.domain.model.person.KnownFor as DomainKnownFor

data class Result(
    val adult: Boolean,
    val gender: Int,
    val id: Int,
    val known_for: List<KnownFor>,
    val known_for_department: String,
    val name: String,
    val popularity: Double,
    val profile_path: Any
)

fun DomainResult.toPresentationPersonResult() = Result(
    adult=adult,
    gender=gender,
    id=id,
    known_for_department=known_for_department,
    name=name,
    popularity=popularity,
    profile_path=profile_path,
    known_for=known_for.toPresentationPersonResultList()

)
fun List<DomainKnownFor>.toPresentationPersonResultList() : List<KnownFor>{
    val list = mutableListOf<KnownFor>()
    this.forEach { list.add(it.toPresentationPersonResult()) }
    return list
}
