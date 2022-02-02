package com.codeinglogs.local.dao.moviedetail.reviews

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.moviedetail.reviews.MovieReviews

@Dao
interface MovieReviewsDao {
    @Insert
    suspend fun insert(movieReviews: MovieReviews)

    @Update
    suspend fun update(movieReviews: MovieReviews)

    @Delete
    suspend fun delete(movieReviews: MovieReviews)

    @Query("SELECT * FROM MovieReviews")
    fun loadAllMovieReviews() : LiveData<MovieReviews>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMovieReviews(vararg movieReviews: MovieReviews)
}