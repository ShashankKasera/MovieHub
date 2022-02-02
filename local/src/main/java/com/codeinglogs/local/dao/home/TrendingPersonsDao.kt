package com.codeinglogs.local.dao.home

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.Persons
import com.codeinglogs.local.entity.home.TrendingPersons

@Dao
interface TrendingPersonsDao {
    @Insert
    suspend fun insert(persons: TrendingPersons)

    @Update
    suspend fun update(persons: TrendingPersons)

    @Delete
    suspend fun delete(persons: TrendingPersons)

    @Query("SELECT * FROM TrendingPersons")
    fun loadAllTrendingPersons() : LiveData<TrendingPersons>

    @Insert
    fun insertAllTrendingPersons(vararg persons: TrendingPersons)

    @Query("SELECT * FROM Persons INNER JOIN TrendingPersons ON Persons.id == TrendingPersons.personId")
    fun getAllTrendingPersons() : List<Persons>
}