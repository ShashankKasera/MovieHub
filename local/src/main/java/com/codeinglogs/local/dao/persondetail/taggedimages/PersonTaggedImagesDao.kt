package com.codeinglogs.local.dao.persondetail.taggedimages

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.person.taggedimages.PersonTaggedImages
@Dao
interface PersonTaggedImagesDao {
    @Insert
    suspend fun insert(personTaggedImages: PersonTaggedImages)

    @Update
    suspend fun update(personTaggedImages: PersonTaggedImages)

    @Delete
    suspend fun delete(personTaggedImages: PersonTaggedImages)

    @Query("SELECT * FROM PersonTaggedImages")
    fun loadAllPersonTaggedImages() : LiveData<PersonTaggedImages>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTvShowGenre(vararg personTaggedImages: PersonTaggedImages)
}