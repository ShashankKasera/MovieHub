package com.codeinglogs.data.model.movies.mylist
import  com.codeinglogs.domain.model.movies.mylist.MyMovieListDetails as DomainMyMovieListDetails
data class MyMovieListDetails (
    val id:Long,
    val myMovieListId:Long,
    val movieId:Long
        )

fun MyMovieListDetails.toDomainMyMovieListDetails()= DomainMyMovieListDetails(
    id = id,
    myMovieListId = myMovieListId,
    movieId=movieId
)

fun List<MyMovieListDetails>.toDomainMyMovieListDetailsList():List<DomainMyMovieListDetails>{
    val list= mutableListOf<DomainMyMovieListDetails>()
    this.forEach { list.add(it.toDomainMyMovieListDetails()) }
    return list
}