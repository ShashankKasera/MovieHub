package com.codeinglogs.local.dao.tvshowdetails.image
import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.tvshowdetails.image.TvShowPoster

@Dao
interface TvShowPosterDao {
    @Insert
    suspend fun insert(tvShowPoster: TvShowPoster)

    @Update
    suspend fun update(tvShowPoster: TvShowPoster)

    @Delete
    suspend fun delete(tvShowPoster: TvShowPoster)

    @Query("SELECT * FROM TvShowPoster")
    fun loadAllTvShowPoster(): LiveData<TvShowPoster>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTvShowPoster(vararg tvShowPoster: TvShowPoster)
}