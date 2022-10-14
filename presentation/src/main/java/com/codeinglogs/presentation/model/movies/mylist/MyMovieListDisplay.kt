package com.codeinglogs.presentation.model.movies.mylist

import com.codeinglogs.domain.model.movies.mylist.MyMovieListDisplay as DomainMyMovieListDisplay
data class MyMovieListDisplay (
    val myMovieListId : Long,
    val myMovieListName : String,
    val myMovieListDetailsId : Long,
    val flag :Boolean
    )

fun DomainMyMovieListDisplay.toPresentationMyMovieListDisplay()=MyMovieListDisplay(
        myMovieListId = myMovieListId,
        myMovieListName = myMovieListName,
        myMovieListDetailsId = myMovieListDetailsId,
        flag = flag
    )

fun List<DomainMyMovieListDisplay>.toPresentationMyMovieListDisplayList():List<MyMovieListDisplay>{
    val list= mutableListOf<MyMovieListDisplay>()
    this.forEach { list.add(it.toPresentationMyMovieListDisplay()) }
    return list
}