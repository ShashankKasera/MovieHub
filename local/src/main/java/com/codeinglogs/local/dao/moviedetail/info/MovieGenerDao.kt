package com.codeinglogs.local.dao.moviedetail.info

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.moviedetail.info.MovieGener

@Dao
interface MovieGenerDao {
    @Insert
    suspend fun insert(movieGener: MovieGener)

    @Update
    suspend fun update(movieGener: MovieGener)

    @Delete
    suspend fun delete(movieGener: MovieGener)

    @Query("SELECT * FROM MovieGener")
    fun loadAllMovieGener() : LiveData<MovieGener>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMovieGener(vararg movieGener: MovieGener)
}