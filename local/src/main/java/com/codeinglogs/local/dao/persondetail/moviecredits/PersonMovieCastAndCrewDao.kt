package com.codeinglogs.local.dao.persondetail.moviecredits

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.person.moviecredits.PersonMovieCastAndCrew
@Dao
interface PersonMovieCastAndCrewDao {
    @Insert
    suspend fun insert(personMovieCastAndCrew: PersonMovieCastAndCrew)

    @Update
    suspend fun update(personMovieCastAndCrew: PersonMovieCastAndCrew)

    @Delete
    suspend fun delete(personMovieCastAndCrew: PersonMovieCastAndCrew)

    @Query("SELECT * FROM PersonMovieCastAndCrew")
    fun loadAllPersonMovieCastAndCrew() : LiveData<PersonMovieCastAndCrew>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPersonMovieCastAndCrew(vararg personMovieCastAndCrew: PersonMovieCastAndCrew)
}