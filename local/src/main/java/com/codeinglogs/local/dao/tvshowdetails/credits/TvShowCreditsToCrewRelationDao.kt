package com.codeinglogs.local.dao.tvshowdetails.credits

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.Persons
import com.codeinglogs.local.entity.tvshowdetails.credits.TvShowCreditsToCrewRelation
@Dao
interface TvShowCreditsToCrewRelationDao {
    @Insert
    suspend fun insert(tvShowCreditsToCrewRelation: TvShowCreditsToCrewRelation)

    @Update
    suspend fun update(tvShowCreditsToCrewRelation: TvShowCreditsToCrewRelation)

    @Delete
    suspend fun delete(tvShowCreditsToCrewRelation: TvShowCreditsToCrewRelation)

    @Query("SELECT * FROM TvShowCreditsToCrewRelation")
    fun loadAllTvShowCreditsToCrewRelation() : LiveData<TvShowCreditsToCrewRelation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTvShowCreditsToCrewRelation(vararg tvShowCreditsToCrewRelation: TvShowCreditsToCrewRelation)

    @Query("SELECT * FROM Persons INNER JOIN tvShowCreditsToCrewRelation ON Persons.id == tvShowCreditsToCrewRelation.tvShowCrewId WHERE tvShowCreditsToCrewRelation.tvShowId == (:tvShowId)")
    fun getTvShowCreditsToCrewRelation(tvShowId : Int) : List<Persons>


}