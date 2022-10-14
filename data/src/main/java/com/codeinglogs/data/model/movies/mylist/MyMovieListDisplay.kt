package com.codeinglogs.data.model.movies.mylist

import com.codeinglogs.domain.model.movies.mylist.MyMovieListDisplay as DomainMyMovieListDisplay
data class MyMovieListDisplay (
    val myMovieListId : Long,
    val myMovieListName : String,
    val myMovieListDetailsId : Long,
    val flag :Boolean
)

fun MyMovieListDisplay.toDomainMyMovieListDisplay()=DomainMyMovieListDisplay(
    myMovieListId=myMovieListId,
    myMovieListName=myMovieListName,
    myMovieListDetailsId=myMovieListDetailsId,
    flag=flag
    )

fun List<MyMovieListDisplay>.toDomainMyMovieListDisplayList():List<DomainMyMovieListDisplay>{
    val list= mutableListOf<DomainMyMovieListDisplay>()
    this.forEach { list.add(it.toDomainMyMovieListDisplay()) }
    return list
}