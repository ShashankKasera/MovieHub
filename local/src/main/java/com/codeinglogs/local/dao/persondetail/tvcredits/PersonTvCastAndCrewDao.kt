package com.codeinglogs.local.dao.persondetail.tvcredits

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.person.tvcredits.PersonTvCastAndCrew
@Dao
interface PersonTvCastAndCrewDao {
    @Insert
    suspend fun insert(personTvCastAndCrew: PersonTvCastAndCrew)

    @Update
    suspend fun update(personTvCastAndCrew: PersonTvCastAndCrew)

    @Delete
    suspend fun delete(personTvCastAndCrew: PersonTvCastAndCrew)

    @Query("SELECT * FROM PersonTvCastAndCrew")
    fun loadAllPersonTvCastAndCrew() : LiveData<PersonTvCastAndCrew>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPersonTvCastAndCrew(vararg personTvCastAndCrew: PersonTvCastAndCrew)
}