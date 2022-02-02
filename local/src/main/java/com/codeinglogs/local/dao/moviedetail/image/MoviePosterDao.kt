package com.codeinglogs.local.dao.moviedetail.image

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.moviedetail.image.MoviePoster

@Dao
interface MoviePosterDao {
    @Insert
    suspend fun insert(moviePoster: MoviePoster)

    @Update
    suspend fun update(moviePoster: MoviePoster)

    @Delete
    suspend fun delete(moviePoster: MoviePoster)

    @Query("SELECT * FROM MoviePoster")
    fun loadAllMoviePoster() : LiveData<MoviePoster>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMoviePoster(vararg moviePoster: MoviePoster)
}