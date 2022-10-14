package com.codeinglogs.data.model.movies.mylist

import  com.codeinglogs.domain.model.movies.mylist.MyMovieList as DomainMayMovieList
data class MyMovieList(

    val id : Long = 0,
    val name : String
)

fun MyMovieList.toDomainMyMovieList()=DomainMayMovieList(
    id=id,
    name=name
)

fun List<MyMovieList>.toDomainMyMovieList():List<DomainMayMovieList>{
    val list= mutableListOf<DomainMayMovieList>()
    this.forEach { list.add(it.toDomainMyMovieList()) }
    return list
}