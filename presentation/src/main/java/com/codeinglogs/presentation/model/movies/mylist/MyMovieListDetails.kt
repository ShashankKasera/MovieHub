package com.codeinglogs.presentation.model.movies.mylist

import  com.codeinglogs.domain.model.movies.mylist.MyMovieListDetails as DomainMyMovieListDetails
data class MyMovieListDetails (
    val id:Long,
    val myMovieListId:Long,
    val movieId:Long
)

fun DomainMyMovieListDetails.toPresentationMyMovieListDetails()=MyMovieListDetails(
    id=id,
    myMovieListId=myMovieListId,
    movieId=movieId
)

fun List<DomainMyMovieListDetails>.toPresentationMyMovieListDetailsList():List<MyMovieListDetails>{
    val list= mutableListOf<MyMovieListDetails>()
    this.forEach { list.add(it.toPresentationMyMovieListDetails()) }
    return list
}