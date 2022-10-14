package com.codeinglogs.local.dao.bookmark
import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.Persons
import com.codeinglogs.local.entity.bookmark.BookmarkPersons

@Dao
interface BookmarkPersonsDao {

    @Insert
    suspend fun insert(persons: BookmarkPersons)

    @Update
    suspend fun update(persons: BookmarkPersons)

    @Delete
    suspend fun delete(persons: BookmarkPersons)

    @Query("SELECT * FROM BookmarkPersons")
    fun loadAllBookmarkPersons() : LiveData<BookmarkPersons>

    @Insert
    fun insertAllBookmarkPersons(vararg persons: BookmarkPersons)

    @Query("SELECT * FROM Persons INNER JOIN BookmarkPersons ON Persons.id == BookmarkPersons.personId")
    fun getAllPopularPersons() : List<Persons>
}