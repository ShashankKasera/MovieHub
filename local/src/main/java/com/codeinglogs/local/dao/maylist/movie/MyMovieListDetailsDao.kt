package com.codeinglogs.local.dao.maylist.movie

import androidx.room.*
import com.codeinglogs.local.entity.moviedetail.reviews.MovieReviews
import com.codeinglogs.local.entity.mylist.movie.MyMovieList
import com.codeinglogs.local.entity.mylist.movie.MyMovieListDetails

@Dao
interface MyMovieListDetailsDao {

    @Insert
    suspend fun insert(myMovieListDetails: MyMovieListDetails):Long

    @Update
    suspend fun update(myMovieListDetails: MyMovieListDetails)

    @Delete
    suspend fun delete(myMovieListDetails: MyMovieListDetails)

    @Query("SELECT * FROM MyMovieListDetails")
    fun getAllMyMovieListDetails() : List<MyMovieListDetails>

    @Query("SELECT * FROM MyMovieListDetails WHERE MyMovieListDetails.myMovieListId == (:myMovieListId) AND MyMovieListDetails.movieId == (:movieId)")
    fun getMyMovieListDetails(myMovieListId : Long,movieId : Long) : List<MyMovieListDetails>

}