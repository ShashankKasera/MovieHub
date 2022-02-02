package com.codeinglogs.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.codeinglogs.data.model.person.personlist.Person as DataPerson

@Entity
data class Persons(
    @PrimaryKey
    val id: Long,
    val known_for_department: String,
    val name: String,
    val character: String,
    val profile_path: String
)

fun Persons.toDataPerson() = DataPerson(
    id=id,
    known_for_department=known_for_department,
    name=name,
    character=character,
    profile_path=profile_path,
)

fun List<Persons>.toDataPersons() : List<DataPerson>{
    val list = mutableListOf<DataPerson>()
    this.forEach { list.add(it.toDataPerson()) }
    return list
}

fun DataPerson.toLocalPersons() = Persons(
    id=id,
    known_for_department=known_for_department,
    name=name,
    character=character,
    profile_path=profile_path,
)

fun List<DataPerson>.toLocalPersons() : List<Persons>{
    val list = mutableListOf<Persons>()
    this.forEach { list.add(it.toLocalPersons()) }
    return list
}
