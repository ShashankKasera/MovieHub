package com.codeinglogs.local.entity.bookmark
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.codeinglogs.local.entity.Persons

import com.codeinglogs.data.model.person.personlist.Person as DataPerson

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Persons::class,
            parentColumns = ["id"],
            childColumns = ["personId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class BookmarkPersons(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    val personId : Long
)

fun DataPerson.toLocalBookmarkPersons() = BookmarkPersons(personId = id)

fun List<DataPerson>.toLocalBookmarkPersonsList() : List<BookmarkPersons>{
    val list = mutableListOf<BookmarkPersons>()
    this.forEach { list.add(it.toLocalBookmarkPersons()) }
    return list
}