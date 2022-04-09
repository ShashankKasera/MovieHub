package com.codeinglogs.local.dao.tvshowdetails.info
import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.Persons
import com.codeinglogs.local.entity.tvshowdetails.info.TvShowGenre
import com.codeinglogs.local.entity.tvshowdetails.info.TvShowInfoToGenerRelation
@Dao
interface TvShowInfoToGenerRelationDao {
    @Insert
    suspend fun insert(tvShowInfoToGenerRelation: TvShowInfoToGenerRelation)

    @Update
    suspend fun update(tvShowInfoToGenerRelation: TvShowInfoToGenerRelation)

    @Delete
    suspend fun delete(tvShowInfoToGenerRelation: TvShowInfoToGenerRelation)

    @Query("SELECT * FROM TvShowInfoToGenerRelation")
    fun loadAllTvShowInfoToGenerRelation() : LiveData<TvShowInfoToGenerRelation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTvShowInfoToGenerRelation(vararg tvShowInfoToGenerRelation: TvShowInfoToGenerRelation)

    @Query("SELECT * FROM TvShowGenre INNER JOIN TvShowInfoToGenerRelation ON TvShowGenre.id == TvShowInfoToGenerRelation.tvShowGenerId WHERE TvShowInfoToGenerRelation.tvShowId == (:tvShowId)")
    fun getTvShowInfoToGenerRelation(tvShowId : Int) : List<TvShowGenre>


}