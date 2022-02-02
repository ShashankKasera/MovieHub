package com.codeinglogs.local.dao.moviedetail.video

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.Persons
import com.codeinglogs.local.entity.moviedetail.reviews.MovieReviews
import com.codeinglogs.local.entity.moviedetail.video.MovieVideo
import com.codeinglogs.local.entity.moviedetail.video.MovieVideoRelation
@Dao
interface MovieVideoRelationDao {
    @Insert
    suspend fun insert(movieVideoRelation: MovieVideoRelation)

    @Update
    suspend fun update(movieVideoRelation: MovieVideoRelation)

    @Delete
    suspend fun delete(movieVideoRelation: MovieVideoRelation)

    @Query("SELECT * FROM MovieVideoRelation")
    fun loadAlMovieVideoRelation() : LiveData<MovieVideoRelation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAlMovieVideoRelation(vararg movieVideoRelation: MovieVideoRelation)


    @Query("SELECT * FROM MovieVideo INNER JOIN movieVideoRelation ON MovieVideo.id == movieVideoRelation.movieVideoId WHERE movieVideoRelation.movieId == (:movieId)")
    fun getMovieVideoRelation(movieId : Int) : List<MovieVideo>


}