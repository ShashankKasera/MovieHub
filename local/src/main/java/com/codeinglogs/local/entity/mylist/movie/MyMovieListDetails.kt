package com.codeinglogs.local.entity.mylist.movie

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.codeinglogs.local.entity.moviedetail.info.MovieInfoResponse
import  com.codeinglogs.data.model.movies.mylist.MyMovieListDetails as DataMyMovieListDetails

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = MyMovieList::class,
            parentColumns = ["id"],
            childColumns = ["myMovieListId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = MovieInfoResponse::class,
            parentColumns = ["id"],
            childColumns = ["movieId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
class MyMovieListDetails (
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val myMovieListId : Long,
    val movieId : Long
)

fun MyMovieListDetails.toDataMyMovieListDetails()=DataMyMovieListDetails(
    id=id,
    myMovieListId=myMovieListId,
    movieId=movieId
)

fun List<MyMovieListDetails>.toDataMyMovieListDetailsList() : List<DataMyMovieListDetails>{
    val list = mutableListOf<DataMyMovieListDetails>()
    this.forEach { list.add(it.toDataMyMovieListDetails()) }
    return list
}