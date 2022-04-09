package com.codeinglogs.local.dao.tvshowdetails.info
import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.tvshowdetails.info.TvShowProductionCompany

@Dao
interface TvShowProductionCompanyDao {
    @Insert
    suspend fun insert(tvShowProductionCompanies: TvShowProductionCompany)

    @Update
    suspend fun update(tvShowProductionCompanies: TvShowProductionCompany)

    @Delete
    suspend fun delete(tvShowProductionCompanies: TvShowProductionCompany)

    @Query("SELECT * FROM TvShowProductionCompany")
    fun loadAllTvShowProductionCompany() : LiveData<TvShowProductionCompany>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTvShowProductionCompany(vararg tvShowProductionCompanies: TvShowProductionCompany)
}