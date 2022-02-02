package com.codeinglogs.local.dao.moviedetail.info

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.Persons
import com.codeinglogs.local.entity.moviedetail.info.MovieGener
import com.codeinglogs.local.entity.moviedetail.info.MovieInfoToGenerRelation
@Dao
interface MovieInfoToGenerRelationDao {

    @Insert
    suspend fun insert(movieInfoToGenerRelation: MovieInfoToGenerRelation)

    @Update
    suspend fun update(movieInfoToGenerRelation: MovieInfoToGenerRelation)

    @Delete
    suspend fun delete(movieInfoToGenerRelation: MovieInfoToGenerRelation)

    @Query("SELECT * FROM MovieInfoToGenerRelation")
    fun loadAllMovieInfoToGenerRelation() : LiveData<MovieInfoToGenerRelation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMovieInfoToGenerRelation(vararg movieInfoToGenerRelation: MovieInfoToGenerRelation)

    @Query("SELECT * FROM MovieGener INNER JOIN MovieInfoToGenerRelation ON MovieGener.id == MovieInfoToGenerRelation.movieGenerId WHERE MovieInfoToGenerRelation.movieId == (:movieId)")
    fun getMovieInfoToGenerRelation(movieId : Int) : List<MovieGener>


}