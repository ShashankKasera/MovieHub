package com.codeinglogs.local.dao.moviedetail.info

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.moviedetail.info.MovieGener
import com.codeinglogs.local.entity.moviedetail.info.MovieInfoToProductionCompaniesRelation
import com.codeinglogs.local.entity.moviedetail.info.MovieProductionCompanies

@Dao
interface MovieInfoToProductionCompaniesRelationDao {

    @Insert
    suspend fun insert(movieInfoToProductionCompaniesRelation: MovieInfoToProductionCompaniesRelation)

    @Update
    suspend fun update(movieInfoToProductionCompaniesRelation: MovieInfoToProductionCompaniesRelation)

    @Delete
    suspend fun delete(movieInfoToProductionCompaniesRelation: MovieInfoToProductionCompaniesRelation)

    @Query("SELECT * FROM MovieInfoToProductionCompaniesRelation")
    fun loadAllMovieInfoToProductionCompaniesRelation() : LiveData<MovieInfoToProductionCompaniesRelation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMovieInfoToProductionCompaniesRelation(vararg movieInfoToProductionCompaniesRelation: MovieInfoToProductionCompaniesRelation)

    @Query("SELECT * FROM MovieProductionCompanies INNER JOIN movieInfoToProductionCompaniesRelation ON MovieProductionCompanies.id == movieInfoToProductionCompaniesRelation.movieProductionCompaniesId WHERE movieInfoToProductionCompaniesRelation.movieId == (:movieId)")
    fun getMovieInfoToProductionCompaniesRelation(movieId : Int) : List<MovieProductionCompanies>
}