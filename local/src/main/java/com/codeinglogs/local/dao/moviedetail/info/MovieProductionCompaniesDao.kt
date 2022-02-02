package com.codeinglogs.local.dao.moviedetail.info

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.moviedetail.info.MovieProductionCompanies

@Dao
interface MovieProductionCompaniesDao {
    @Insert
    suspend fun insert(movieProductionCompanies: MovieProductionCompanies)

    @Update
    suspend fun update(movieProductionCompanies: MovieProductionCompanies)

    @Delete
    suspend fun delete(movieProductionCompanies: MovieProductionCompanies)

    @Query("SELECT * FROM MovieProductionCompanies")
    fun loadAllMovieProductionCompanies() : LiveData<MovieProductionCompanies>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMovieProductionCompanies(vararg movieProductionCompanies: MovieProductionCompanies)
}