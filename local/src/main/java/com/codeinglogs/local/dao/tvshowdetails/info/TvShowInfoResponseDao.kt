package com.codeinglogs.local.dao.tvshowdetails.info
import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.tvshowdetails.info.TvShowInfoResponse
@Dao
interface TvShowInfoResponseDao {
    @Insert
    suspend fun insert(tvShowInfoResponse: TvShowInfoResponse)

    @Update
    suspend fun update(tvShowInfoResponse: TvShowInfoResponse)

    @Delete
    suspend fun delete(tvShowInfoResponse: TvShowInfoResponse)

    @Query("SELECT * FROM TvShowInfoResponse")
    fun loadAllTvShowInfoResponse() : LiveData<TvShowInfoResponse>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTvShowInfoResponse(vararg tvShowInfoResponse: TvShowInfoResponse)

    @Query("SELECT * FROM TvShowInfoResponse WHERE TvShowInfoResponse.id == (:tvShowId)")
    fun getTvShowInfoResponse(tvShowId : Int) : TvShowInfoResponse

    @Query("SELECT EXISTS(SELECT * FROM TvShowInfoResponse WHERE id = :tvShowId)")
    fun isTvShowInfoIsExist(tvShowId : Int) : Boolean
}