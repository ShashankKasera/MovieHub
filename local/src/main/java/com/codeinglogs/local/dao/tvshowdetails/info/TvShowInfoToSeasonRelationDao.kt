package com.codeinglogs.local.dao.tvshowdetails.info

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.tvshowdetails.info.TvShowSeason
import com.codeinglogs.local.entity.tvshowdetails.info.TvShowInfoToSeasonRelation

@Dao
interface TvShowInfoToSeasonRelationDao  {
    @Insert
    suspend fun insert(tvShowInfoToSeasonRelation: TvShowInfoToSeasonRelation)

    @Update
    suspend fun update(tvShowInfoToSeasonRelation: TvShowInfoToSeasonRelation)

    @Delete
    suspend fun delete(tvShowInfoToSeasonRelation: TvShowInfoToSeasonRelation)

    @Query("SELECT * FROM TvShowInfoToSeasonRelation")
    fun loadAllTvShowInfoToSeasonRelation() : LiveData<TvShowInfoToSeasonRelation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTvShowInfoToSeasonRelation(vararg tvShowInfoToSeasonRelation: TvShowInfoToSeasonRelation)

    @Query("SELECT * FROM TvShowSeason INNER JOIN TvShowInfoToSeasonRelation ON TvShowSeason.id == TvShowInfoToSeasonRelation.tvShowSeasonId WHERE TvShowInfoToSeasonRelation.tvShowId == (:tvShowId)")
    fun getTvShowInfoToSeasonRelation(tvShowId : Int) : List<TvShowSeason>

}