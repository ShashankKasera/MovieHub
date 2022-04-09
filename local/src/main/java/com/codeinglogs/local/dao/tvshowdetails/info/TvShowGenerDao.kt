package com.codeinglogs.local.dao.tvshowdetails.info

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.tvshowdetails.info.TvShowGenre

@Dao
interface TvShowGenreDao {
    @Insert
    suspend fun insert(tvShowGener: TvShowGenre)

    @Update
    suspend fun update(tvShowGener: TvShowGenre)

    @Delete
    suspend fun delete(tvShowGener: TvShowGenre)

    @Query("SELECT * FROM TvShowGenre")
    fun loadAllTvShowGenre() : LiveData<TvShowGenre>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTvShowGenre(vararg tvShowGener: TvShowGenre)
}
