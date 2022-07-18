package com.codeinglogs.local.dao.persondetail.taggedimages

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.Persons
import com.codeinglogs.local.entity.person.taggedimages.PersonTaggedImages
import com.codeinglogs.local.entity.person.taggedimages.PersonTaggedImagesRelation

@Dao
interface PersonTaggedImagesRelationDao {
    @Insert
    suspend fun insert(personTaggedImages: PersonTaggedImagesRelation)

    @Update
    suspend fun update(personTaggedImages: PersonTaggedImagesRelation)

    @Delete
    suspend fun delete(personTaggedImages: PersonTaggedImagesRelation)

    @Query("SELECT * FROM PersonTaggedImagesRelation")
    fun loadAllPersonTaggedImagesRelation() : LiveData<PersonTaggedImagesRelation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPersonTaggedImagesRelation(vararg personTaggedImagesRelation: PersonTaggedImagesRelation)

    @Query("SELECT * FROM PersonTaggedImages INNER JOIN PersonTaggedImagesRelation ON PersonTaggedImagesRelation.personTaggedImagesFilePath == PersonTaggedImages.file_path WHERE PersonTaggedImagesRelation.personId == (:personId)")
    fun getPersonTaggedImagesRelation(personId : Int) : List<PersonTaggedImages>
}