package com.codeinglogs.local.entity.home

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import com.codeinglogs.local.entity.Persons
import com.codeinglogs.data.model.person.personlist.Person as DataPerson

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Persons::class,
            parentColumns = ["id"],
            childColumns = ["personId"],
            onDelete = CASCADE
        )
    ]
)
data class TrendingPersons(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    val personId : Long
)

fun DataPerson.toLocalTrendingPersons() = TrendingPersons(personId = id)

fun List<DataPerson>.toLocalTrendingPersonsList() : List<TrendingPersons>{
    val list = mutableListOf<TrendingPersons>()
    this.forEach { list.add(it.toLocalTrendingPersons()) }
    return list
}



