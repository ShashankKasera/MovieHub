package com.codeinglogs.local.dao.persondetail.externalids

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.person.externalids.PersonExternalIdsResponse
@Dao
interface PersonExternalIdsResponseDao {
    @Insert
    suspend fun insert(personExternalIdsResponse: PersonExternalIdsResponse)

    @Update
    suspend fun update(personExternalIdsResponse: PersonExternalIdsResponse)

    @Delete
    suspend fun delete(personExternalIdsResponse: PersonExternalIdsResponse)

    @Query("SELECT * FROM PersonExternalIdsResponse")
    fun loadAllPersonExternalIdsResponse() : LiveData<PersonExternalIdsResponse>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPersonExternalIdsResponse(vararg personExternalIdsResponse: PersonExternalIdsResponse)

    @Query("SELECT * FROM PersonExternalIdsResponse WHERE PersonExternalIdsResponse.id == (:personId)")
    fun getPersonExternalIdsResponse(personId : Int) : PersonExternalIdsResponse
}