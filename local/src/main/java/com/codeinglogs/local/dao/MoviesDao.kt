package com.codeinglogs.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.Movies

@Dao
interface MoviesDao {
    @Insert
    suspend fun insert(movies: Movies)

    @Update
    suspend fun update(movies: Movies)

    @Delete
    suspend fun delete(movies: Movies)

    @Query("SELECT * FROM Movies")
    fun loadAllMovies() : LiveData<Movies>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMovies(vararg movies: Movies)
}