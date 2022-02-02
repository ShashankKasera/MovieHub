package com.codeinglogs.local.dao.moviedetail.reviews

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.moviedetail.info.MovieGener
import com.codeinglogs.local.entity.moviedetail.reviews.MovieReviewRelation
import com.codeinglogs.local.entity.moviedetail.reviews.MovieReviews

@Dao
interface MovieReviewRelationDao {

    @Insert
    suspend fun insert(movieReviewRelation: MovieReviewRelation)

    @Update
    suspend fun update(movieReviewRelation: MovieReviewRelation)

    @Delete
    suspend fun delete(movieReviewRelation: MovieReviewRelation)

    @Query("SELECT * FROM MovieReviewRelation")
    fun loadAllMovieReviewRelation() : LiveData<MovieReviewRelation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMovieReviewRelation(vararg movieReviewRelation: MovieReviewRelation)

    @Query("SELECT * FROM MovieReviews INNER JOIN movieReviewRelation ON MovieReviews.id == movieReviewRelation.movieReviewsId WHERE movieReviewRelation.movieId == (:movieId)")
    fun getMovieReviewRelation(movieId : Int) : List<MovieReviews>
}