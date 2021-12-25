package com.codeinglogs.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.Movies
import com.codeinglogs.local.entity.TvShows

@Dao
interface TvShowsDao {
    @Insert
    suspend fun insert(tvShows: TvShows)

    @Update
    suspend fun update(tvShows: TvShows)

    @Delete
    suspend fun delete(tvShows: TvShows)

    @Query("SELECT * FROM TvShows")
    fun loadAllTvShows() : LiveData<TvShows>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTvShows(vararg tvShows: TvShows)
}