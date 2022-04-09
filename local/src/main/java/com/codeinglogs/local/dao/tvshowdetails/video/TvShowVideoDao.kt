package com.codeinglogs.local.dao.tvshowdetails.video
import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.tvshowdetails.video.TvShowVideo

@Dao
interface TvShowVideoDao {
    @Insert
    suspend fun insert(tvShowVideo: TvShowVideo)

    @Update
    suspend fun update(tvShowVideo: TvShowVideo)

    @Delete
    suspend fun delete(tvShowVideo: TvShowVideo)

    @Query("SELECT * FROM TvShowVideo")
    fun loadAllTvShowVideo() : LiveData<TvShowVideo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTvShowVideo(vararg tvShowVideo: TvShowVideo)
}