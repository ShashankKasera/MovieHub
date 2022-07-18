package com.codeinglogs.local.dao.persondetail.info

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.person.info.PersonInfoResponse
@Dao
interface PersonInfoResponseDao {
    @Insert
    suspend fun insert(personInfoResponse: PersonInfoResponse)

    @Update
    suspend fun update(personInfoResponse: PersonInfoResponse)

    @Delete
    suspend fun delete(personInfoResponse: PersonInfoResponse)

    @Query("SELECT * FROM PersonInfoResponse")
    fun loadAllPersonInfoResponse() : LiveData<PersonInfoResponse>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPersonInfoResponse(vararg personInfoResponse: PersonInfoResponse)

    @Query("SELECT * FROM PersonInfoResponse WHERE PersonInfoResponse.id == (:personId)")
    fun getPersonInfoResponse(personId : Int) : PersonInfoResponse

    @Query("SELECT EXISTS(SELECT * FROM PersonInfoResponse WHERE id = :personId)")
    fun isPersonInfoIsExist(personId : Int) : Boolean
}

