package com.codeinglogs.local.dao.persondetail.moviecredits

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.Persons
import com.codeinglogs.local.entity.person.moviecredits.PersonMovieCastAndCrew
import com.codeinglogs.local.entity.person.moviecredits.PersonMovieCastAndCrewRelation
@Dao
interface PersonMovieCastAndCrewRelationDao {
    @Insert
    suspend fun insert(personMovieCastAndCrewRelation: PersonMovieCastAndCrewRelation)

    @Update
    suspend fun update(personMovieCastAndCrewRelation: PersonMovieCastAndCrewRelation)

    @Delete
    suspend fun delete(personMovieCastAndCrewRelation: PersonMovieCastAndCrewRelation)

    @Query("SELECT * FROM PersonMovieCastAndCrewRelation")
    fun loadAllPersonMovieCastAndCrewRelation() : LiveData<PersonMovieCastAndCrewRelation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPersonMovieCastAndCrewRelation(vararg personMovieCastAndCrewRelation: PersonMovieCastAndCrewRelation)

    @Query("SELECT * FROM PersonMovieCastAndCrew INNER JOIN PersonMovieCastAndCrewRelation ON PersonMovieCastAndCrew.id == PersonMovieCastAndCrewRelation.personMovieCastAndCrewId WHERE PersonMovieCastAndCrewRelation.personId == (:personId)")
    fun getPersonMovieCastAndCrewRelation(personId : Int) : List<PersonMovieCastAndCrew>
}