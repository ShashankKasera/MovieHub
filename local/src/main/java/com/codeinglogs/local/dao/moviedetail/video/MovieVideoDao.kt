package com.codeinglogs.local.dao.moviedetail.video

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.moviedetail.video.MovieVideo

@Dao
interface MoviesVideoDao {
    @Insert
    suspend fun insert(movieVideo: MovieVideo)

    @Update
    suspend fun update(movieVideo: MovieVideo)

    @Delete
    suspend fun delete(movieVideo: MovieVideo)

    @Query("SELECT * FROM MovieVideo")
    fun loadAllMovieVideo() : LiveData<MovieVideo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMovieVideo(vararg movieVideo: MovieVideo)
}