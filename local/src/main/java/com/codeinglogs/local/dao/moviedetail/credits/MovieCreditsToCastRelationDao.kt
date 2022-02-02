package com.codeinglogs.local.dao.moviedetail.credits

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.Movies
import com.codeinglogs.local.entity.Persons
import com.codeinglogs.local.entity.moviedetail.credits.MovieCreditsToCastRelation

@Dao
interface MovieCreditsToCastRelationDao {
    @Insert
    suspend fun insert(movieCreditsToCastRelation: MovieCreditsToCastRelation)

    @Update
    suspend fun update(movieCreditsToCastRelation: MovieCreditsToCastRelation)

    @Delete
    suspend fun delete(movieCreditsToCastRelation: MovieCreditsToCastRelation)

    @Query("SELECT * FROM MovieCreditsToCastRelation")
    fun loadAllMovieCreditsToCastRelation() : LiveData<MovieCreditsToCastRelation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMovieCreditsToCastRelation(vararg movieCreditsToCastRelation: MovieCreditsToCastRelation)

    @Query("SELECT * FROM Persons INNER JOIN movieCreditsToCastRelation ON Persons.id == movieCreditsToCastRelation.movieCastId WHERE movieCreditsToCastRelation.movieId == (:movieId)")
    fun getMovieCreditsToCastRelation(movieId : Int) : List<Persons>

    @Query("SELECT EXISTS(SELECT * FROM MovieCreditsToCastRelation WHERE MovieCreditsToCastRelation.movieId = :movieId AND MovieCreditsToCastRelation.movieCastId = :personId)")
    fun isRowIsExist(movieId : Int,personId : Int) : Boolean

}