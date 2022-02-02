package com.codeinglogs.local.dao.home

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.TvShows
import com.codeinglogs.local.entity.home.TrendingTvShows

@Dao
interface TrendingTvShowsDao {
    @Insert
    suspend fun insert(tvShow: TrendingTvShows)

    @Update
    suspend fun update(tvShow: TrendingTvShows)

    @Delete
    suspend fun delete(tvShow: TrendingTvShows)

    @Query("SELECT * FROM TrendingTvShows")
    fun loadAllTrendingTvShows() : LiveData<TrendingTvShows>

    @Insert
    fun insertAllTrendingTvShows(vararg tvShow: TrendingTvShows)

    @Query("SELECT * FROM TvShows INNER JOIN TrendingTvShows ON TvShows.id == TrendingTvShows.tvShowId")
    fun getAllTrendingTvShows() : List<TvShows>
}