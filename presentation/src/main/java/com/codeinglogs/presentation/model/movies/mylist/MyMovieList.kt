package com.codeinglogs.presentation.model.movies.mylist

import  com.codeinglogs.domain.model.movies.mylist.MyMovieList as DomainMyMovieList
data class MyMovieList(

    val id : Long = 0,
    val name : String
)

fun DomainMyMovieList.toPresentationMyMovieList()=MyMovieList(
    id=id,
    name=name
)

fun List<DomainMyMovieList>.toPresentationMyMovieList():List<MyMovieList>{
    val list= mutableListOf<MyMovieList>()
    this.forEach { list.add(it.toPresentationMyMovieList()) }
    return list
}