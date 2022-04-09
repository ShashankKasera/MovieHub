package com.codeinglogs.local.dao.moviedetail.credits


import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.Persons
import com.codeinglogs.local.entity.moviedetail.credits.MovieCreditsToCrewRelation

@Dao
interface MovieCreditsToCrewRelationDao {
    @Insert
    suspend fun insert(movieCreditsToCrewRelation: MovieCreditsToCrewRelation)

    @Update
    suspend fun update(movieCreditsToCrewRelation: MovieCreditsToCrewRelation)

    @Delete
    suspend fun delete(movieCreditsToCrewRelation: MovieCreditsToCrewRelation)

    @Query("SELECT * FROM MovieCreditsToCrewRelation")
    fun loadAllMovieCreditsToCrewRelation() : LiveData<MovieCreditsToCrewRelation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMovieCreditsToCrewRelation(vararg movieCreditsToCrewRelation: MovieCreditsToCrewRelation)

    @Query("SELECT * FROM Persons INNER JOIN movieCreditsToCrewRelation ON Persons.id == movieCreditsToCrewRelation.movieCrewId WHERE movieCreditsToCrewRelation.movieId == (:movieId)")
    fun getMovieCreditsToCrewRelation(movieId : Int) : List<Persons>

}