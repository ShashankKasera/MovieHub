package com.codeinglogs.local.dao.moviedetail.image

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.moviedetail.image.MovieBackdrop

@Dao
interface MovieBackdropDao {
    @Insert
    suspend fun insert(movieBackdrop: MovieBackdrop)

    @Update
    suspend fun update(movieBackdrop: MovieBackdrop)

    @Delete
    suspend fun delete(movieBackdrop: MovieBackdrop)

    @Query("SELECT * FROM MovieBackdrop")
    fun loadAllMovieBackdrop() : LiveData<MovieBackdrop>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMovieBackdrop(vararg movieBackdrop: MovieBackdrop)
}