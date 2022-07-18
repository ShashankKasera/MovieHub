package com.codeinglogs.local.dao.persondetail.tvcredits

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.Persons
import com.codeinglogs.local.entity.person.tvcredits.PersonTvCastAndCrew
import com.codeinglogs.local.entity.person.tvcredits.PersonTvCastAndCrewRelation
@Dao
interface PersonTvCastAndCrewRelationDao {
    @Insert
    suspend fun insert(personTvCastAndCrewRelation: PersonTvCastAndCrewRelation)

    @Update
    suspend fun update(personTvCastAndCrewRelation: PersonTvCastAndCrewRelation)

    @Delete
    suspend fun delete(personTvCastAndCrewRelation: PersonTvCastAndCrewRelation)

    @Query("SELECT * FROM PersonTvCastAndCrewRelation")
    fun loadAllPersonTvCastAndCrewRelation() : LiveData<PersonTvCastAndCrewRelation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPersonTvCastAndCrewRelation(vararg personTvCastAndCrewRelation: PersonTvCastAndCrewRelation)

    @Query("SELECT * FROM PersonTvCastAndCrew INNER JOIN PersonTvCastAndCrewRelation ON PersonTvCastAndCrew.id == PersonTvCastAndCrewRelation.personTvCastAndCrewId WHERE PersonTvCastAndCrewRelation.personId == (:personId)")
    fun getPersonTvCastAndCrewRelation(personId : Int) : List<PersonTvCastAndCrew>
}