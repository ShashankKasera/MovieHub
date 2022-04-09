package com.codeinglogs.local.dao.tvshowdetails.info

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.tvshowdetails.info.TvShowInfoToProductionCompaniesRelation
import com.codeinglogs.local.entity.tvshowdetails.info.TvShowProductionCompany

@Dao
interface TvShowInfoToProductionCompaniesRelationDao {
    @Insert
    suspend fun insert(tvShowInfoToProductionCompaniesRelation: TvShowInfoToProductionCompaniesRelation)

    @Update
    suspend fun update(tvShowInfoToProductionCompaniesRelation: TvShowInfoToProductionCompaniesRelation)

    @Delete
    suspend fun delete(tvShowInfoToProductionCompaniesRelation: TvShowInfoToProductionCompaniesRelation)

    @Query("SELECT * FROM TvShowInfoToProductionCompaniesRelation")
    fun loadAllTvShowInfoToProductionCompaniesRelation() : LiveData<TvShowInfoToProductionCompaniesRelation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTvShowInfoToProductionCompaniesRelation(vararg tvShowInfoToProductionCompaniesRelation: TvShowInfoToProductionCompaniesRelation)

    @Query("SELECT * FROM TvShowProductionCompany INNER JOIN tvShowInfoToProductionCompaniesRelation ON TvShowProductionCompany.id == tvShowInfoToProductionCompaniesRelation.tvShowProductionCompaniesId WHERE tvShowInfoToProductionCompaniesRelation.tvShowId == (:tvShowId)")
    fun getTvShowInfoToProductionCompaniesRelation(tvShowId : Int) : List<TvShowProductionCompany>
}