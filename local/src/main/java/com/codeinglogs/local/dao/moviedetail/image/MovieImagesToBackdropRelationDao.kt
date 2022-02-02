package com.codeinglogs.local.dao.moviedetail.image

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.Persons
import com.codeinglogs.local.entity.moviedetail.image.MovieBackdrop
import com.codeinglogs.local.entity.moviedetail.image.MovieImagesToBackdropRelation
@Dao
interface MovieImagesToBackdropRelationDao {

    @Insert
    suspend fun insert(movieImagesToBackdropRelation: MovieImagesToBackdropRelation)

    @Update
    suspend fun update(movieImagesToBackdropRelation: MovieImagesToBackdropRelation)

    @Delete
    suspend fun delete(movieImagesToBackdropRelation: MovieImagesToBackdropRelation)

    @Query("SELECT * FROM MovieImagesToBackdropRelation")
    fun loadAllMovieImagesToBackdropRelation() : LiveData<MovieImagesToBackdropRelation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMovieImagesToBackdropRelation(vararg movieImagesToBackdropRelation: MovieImagesToBackdropRelation)

    @Query("SELECT * FROM MovieBackdrop INNER JOIN MovieImagesToBackdropRelation ON MovieBackdrop.file_path == MovieImagesToBackdropRelation.movieBackdropFilePath WHERE movieImagesToBackdropRelation.movieId == (:movieId)")
    fun getMovieImagesToBackdropRelation(movieId : Int) : List<MovieBackdrop>
}