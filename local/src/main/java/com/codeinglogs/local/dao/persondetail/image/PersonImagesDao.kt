package com.codeinglogs.local.dao.persondetail.image

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.person.image.PersonImages
@Dao
interface PersonImagesDao {
    @Insert
    suspend fun insert(personImages: PersonImages)

    @Update
    suspend fun update(personImages: PersonImages)

    @Delete
    suspend fun delete(personImages: PersonImages)

    @Query("SELECT * FROM PersonImages")
    fun loadAllPersonImages() : LiveData<PersonImages>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPersonImages(vararg personImages: PersonImages)
}
