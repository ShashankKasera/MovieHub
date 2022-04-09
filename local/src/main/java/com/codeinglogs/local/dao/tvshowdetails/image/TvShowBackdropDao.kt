package com.codeinglogs.local.dao.tvshowdetails.image
import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.tvshowdetails.image.TvShowBackdrop

@Dao
interface TvShowBackdropDao {
    @Insert
    suspend fun insert(tvShowBackdrop: TvShowBackdrop)

    @Update
    suspend fun update(tvShowBackdrop: TvShowBackdrop)

    @Delete
    suspend fun delete(tvShowBackdrop: TvShowBackdrop)

    @Query("SELECT * FROM TvShowBackdrop")
    fun loadAllTvShowBackdrop() : LiveData<TvShowBackdrop>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTvShowBackdrop(vararg tvShowBackdrop: TvShowBackdrop)
}