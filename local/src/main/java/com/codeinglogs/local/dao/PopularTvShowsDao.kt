package com.codeinglogs.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.PopularTvShows
import com.codeinglogs.local.entity.TvShows

@Dao
interface PopularTvShowsDao {
    @Insert
    suspend fun insert(tvShow: PopularTvShows)

    @Update
    suspend fun update(tvShow: PopularTvShows)

    @Delete
    suspend fun delete(tvShow: PopularTvShows)

    @Query("SELECT * FROM PopularTvShows")
    fun loadAllPopularTvShows() : LiveData<PopularTvShows>

    @Insert
    fun insertAllPopularTvShows(vararg tvShow: PopularTvShows)

    @Query("SELECT * FROM TvShows INNER JOIN PopularTvShows ON TvShows.id == PopularTvShows.tvShowId")
    fun getAllPopularTvShows() : List<TvShows>
}