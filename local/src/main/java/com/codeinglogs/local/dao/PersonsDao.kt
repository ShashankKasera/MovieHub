package com.codeinglogs.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.Movies
import com.codeinglogs.local.entity.Persons

@Dao
interface PersonsDao {
    @Insert
    suspend fun insert(persons: Persons)

    @Update
    suspend fun update(persons: Persons)

    @Delete
    suspend fun delete(persons: Persons)

    @Query("SELECT * FROM Persons")
    fun loadAllPersons() : LiveData<Persons>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPersons(vararg persons: Persons)
}