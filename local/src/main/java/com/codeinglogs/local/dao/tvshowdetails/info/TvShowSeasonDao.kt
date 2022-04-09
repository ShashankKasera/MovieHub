package com.codeinglogs.local.dao.tvshowdetails.info
import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.tvshowdetails.info.TvShowSeason
@Dao
interface TvShowSeasonDao {
    @Insert
    suspend fun insert(tvShowSeason: TvShowSeason)

    @Update
    suspend fun update(tvShowSeason: TvShowSeason)

    @Delete
    suspend fun delete(tvShowSeason: TvShowSeason)

    @Query("SELECT * FROM TvShowSeason")
    fun loadAllTvShowSeason() : LiveData<TvShowSeason>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTvShowSeason(vararg tvShowSeason: TvShowSeason)
}
