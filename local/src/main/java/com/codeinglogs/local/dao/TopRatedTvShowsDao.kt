package com.codeinglogs.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.TopRatedTvShows
import com.codeinglogs.local.entity.TvShows

@Dao
interface TopRatedTvShowsDao {
    @Insert
    suspend fun insert(tvShow: TopRatedTvShows)

    @Update
    suspend fun update(tvShow: TopRatedTvShows)

    @Delete
    suspend fun delete(tvShow: TopRatedTvShows)

    @Query("SELECT * FROM TopRatedTvShows")
    fun loadAllTopRatedTvShows() : LiveData<TopRatedTvShows>

    @Insert
    fun insertAllTopRatedTvShows(vararg tvShow: TopRatedTvShows)

    @Query("SELECT * FROM TvShows INNER JOIN TopRatedTvShows ON TvShows.id == TopRatedTvShows.tvShowId")
    fun getAllTopRatedTvShows() : List<TvShows>
}