package com.codeinglogs.local.entity.mylist.movie

import androidx.room.Entity
import androidx.room.PrimaryKey
import  com.codeinglogs.data.model.movies.mylist.MyMovieList as DataMyMovieList
@Entity
data class MyMovieList(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    val name : String
)

fun MyMovieList.toDataMyMovieList()=DataMyMovieList(
    id=id,
    name=name
)

fun List<MyMovieList>.toDataMyMovieList() : List<DataMyMovieList>{
    val list = mutableListOf<DataMyMovieList>()
    this.forEach { list.add(it.toDataMyMovieList()) }
    return list
}

fun DataMyMovieList.toLocalMyMovieList()=MyMovieList(
    id=id,
    name=name
)

fun List<DataMyMovieList>.toLocalMyMovieList() : List<MyMovieList>{
    val list = mutableListOf<MyMovieList>()
    this.forEach { list.add(it.toLocalMyMovieList()) }
    return list
}