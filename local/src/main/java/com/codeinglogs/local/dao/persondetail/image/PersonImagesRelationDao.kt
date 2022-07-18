package com.codeinglogs.local.dao.persondetail.image

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.person.image.PersonImages
import com.codeinglogs.local.entity.person.image.PersonImagesRelation
@Dao
interface PersonImagesRelationDao {
    @Insert
    suspend fun insert(personImagesRelation: PersonImagesRelation)

    @Update
    suspend fun update(personImagesRelation: PersonImagesRelation)

    @Delete
    suspend fun delete(personImagesRelation: PersonImagesRelation)

    @Query("SELECT * FROM PersonImagesRelation")
    fun loadAllPersonImagesRelation() : LiveData<PersonImagesRelation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPersonImagesRelation(vararg personImagesRelation: PersonImagesRelation)

    @Query("SELECT * FROM PersonImages INNER JOIN PersonImagesRelation ON PersonImagesRelation.PersonImagesFilePath == PersonImages.file_path WHERE PersonImagesRelation.personId == (:personId)")
    fun getPersonImagesRelation(personId : Int) : List<PersonImages>
}