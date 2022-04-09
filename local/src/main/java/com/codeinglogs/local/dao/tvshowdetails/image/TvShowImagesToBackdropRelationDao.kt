package com.codeinglogs.local.dao.tvshowdetails.image
import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.tvshowdetails.image.TvShowBackdrop
import com.codeinglogs.local.entity.tvshowdetails.image.TvShowImagesToBackdropRelation
@Dao
interface TvShowImagesToBackdropRelationDao {
    @Insert
    suspend fun insert(tvShowImagesToBackdropRelation: TvShowImagesToBackdropRelation)

    @Update
    suspend fun update(tvShowImagesToBackdropRelation: TvShowImagesToBackdropRelation)

    @Delete
    suspend fun delete(tvShowImagesToBackdropRelation: TvShowImagesToBackdropRelation)

    @Query("SELECT * FROM TvShowImagesToBackdropRelation")
    fun loadAllTvShowImagesToBackdropRelation() : LiveData<TvShowImagesToBackdropRelation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTvShowImagesToBackdropRelation(vararg tvShowImagesToBackdropRelation: TvShowImagesToBackdropRelation)

    @Query("SELECT * FROM TvShowBackdrop INNER JOIN TvShowImagesToBackdropRelation ON TvShowBackdrop.file_path == TvShowImagesToBackdropRelation.tvShowBackdropFilePath WHERE tvShowImagesToBackdropRelation.tvShowId == (:tvShowId)")
    fun getTvShowImagesToBackdropRelation(tvShowId : Int) : List<TvShowBackdrop>
}