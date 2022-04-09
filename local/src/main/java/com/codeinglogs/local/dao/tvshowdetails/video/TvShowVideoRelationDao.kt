package com.codeinglogs.local.dao.tvshowdetails.video
import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.tvshowdetails.video.TvShowVideo
import com.codeinglogs.local.entity.tvshowdetails.video.TvShowVideoRelation
@Dao
interface TvShowVideoRelationDao {
    @Insert
    suspend fun insert(tvShowVideoRelation: TvShowVideoRelation)

    @Update
    suspend fun update(tvShowVideoRelation: TvShowVideoRelation)

    @Delete
    suspend fun delete(tvShowVideoRelation: TvShowVideoRelation)

    @Query("SELECT * FROM TvShowVideoRelation")
    fun loadAlTvShowVideoRelation() : LiveData<TvShowVideoRelation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAlTvShowVideoRelation(vararg tvShowVideoRelation: TvShowVideoRelation)


    @Query("SELECT * FROM TvShowVideo INNER JOIN tvShowVideoRelation ON TvShowVideo.id == tvShowVideoRelation.tvShowVideoId WHERE tvShowVideoRelation.tvShowId == (:tvShowId)")
    fun getTvShowVideoRelation(tvShowId : Int) : List<TvShowVideo>


}