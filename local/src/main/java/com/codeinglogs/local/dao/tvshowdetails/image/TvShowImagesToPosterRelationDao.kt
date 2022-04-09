package com.codeinglogs.local.dao.tvshowdetails.image

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.tvshowdetails.image.TvShowImagesToTvShowPosterRelation
import com.codeinglogs.local.entity.tvshowdetails.image.TvShowPoster

@Dao
interface TvShowImagesToPosterRelationDao {
    @Insert
    suspend fun insert(tvShowImagesToTvShowPosterRelation: TvShowImagesToTvShowPosterRelation)

    @Update
    suspend fun update(tvShowImagesToTvShowPosterRelation: TvShowImagesToTvShowPosterRelation)

    @Delete
    suspend fun delete(tvShowImagesToTvShowPosterRelation: TvShowImagesToTvShowPosterRelation)

    @Query("SELECT * FROM TvShowImagesToTvShowPosterRelation")
    fun loadAllTvShowImagesToTvShowPosterRelation() : LiveData<TvShowImagesToTvShowPosterRelation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTvShowImagesToTvShowPosterRelation(vararg tvShowImagesToTvShowPosterRelation: TvShowImagesToTvShowPosterRelation)

    @Query("SELECT * FROM TvShowPoster INNER JOIN tvShowImagesToTvShowPosterRelation ON TvShowPoster.file_path == tvShowImagesToTvShowPosterRelation.tvShowPosterFilePath WHERE tvShowImagesToTvShowPosterRelation.tvShowId == (:tvShowId)")
    fun getTvShowImagesToTvShowPosterRelation(tvShowId : Int) : List<TvShowPoster>
}