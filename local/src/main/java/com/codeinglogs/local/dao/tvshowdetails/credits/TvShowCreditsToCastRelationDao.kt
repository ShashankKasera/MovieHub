package com.codeinglogs.local.dao.tvshowdetails.credits
import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.Persons
import com.codeinglogs.local.entity.tvshowdetails.credits.TvShowCreditsToCastRelation

@Dao
interface TvShowCreditsToCastRelationDao {
    @Insert
    suspend fun insert(tvShowCreditsToCastRelation: TvShowCreditsToCastRelation)

    @Update
    suspend fun update(tvShowCreditsToCastRelation: TvShowCreditsToCastRelation)

    @Delete
    suspend fun delete(tvShowCreditsToCastRelation: TvShowCreditsToCastRelation)

    @Query("SELECT * FROM TvShowCreditsToCastRelation")
    fun loadAllTvShowCreditsToCastRelation() : LiveData<TvShowCreditsToCastRelation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTvShowCreditsToCastRelation(vararg tvShowCreditsToCastRelation: TvShowCreditsToCastRelation)

    @Query("SELECT * FROM Persons INNER JOIN tvShowCreditsToCastRelation ON Persons.id == tvShowCreditsToCastRelation.tvShowCastId WHERE tvShowCreditsToCastRelation.tvShowId == (:tvShowId)")
    fun getTvShowCreditsToCastRelation(tvShowId : Int) : List<Persons>

    @Query("SELECT EXISTS(SELECT * FROM TvShowCreditsToCastRelation WHERE TvShowCreditsToCastRelation.tvShowId = :tvShowId AND TvShowCreditsToCastRelation.tvShowCastId = :personId)")
    fun isRowIsExist(tvShowId : Int,personId : Int) : Boolean

}