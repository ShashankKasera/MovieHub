package com.codeinglogs.remote.model.person

import com.codeinglogs.data.model.person.Result as DataResult
import com.codeinglogs.data.model.person.KnownFor as DataRKnownFor

data class Result(
    val adult: Boolean?,
    val gender: Int?,
    val id: Int?,
    val known_for: List<KnownFor>?,
    val known_for_department: String?,
    val name: String?,
    val popularity: Double?,
    val profile_path: String
)

fun Result.toDataPersonResult() = DataResult(
    adult=adult?:false,
    gender=gender?:0,
    id=id?:0,
    known_for_department=known_for_department?:"",
    name=name?:"",
    popularity=popularity?:0.0,
    profile_path=profile_path?:"",
    known_for=known_for?.toDataPersonResultList()?: listOf()

)
fun List<KnownFor>.toDataPersonResultList() : List<DataRKnownFor>{
    val list = mutableListOf<DataRKnownFor>()
    this.forEach { list.add(it.toDataPersonResult()) }
    return list
}
