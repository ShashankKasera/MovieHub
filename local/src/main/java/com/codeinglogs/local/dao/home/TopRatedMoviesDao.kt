package com.codeinglogs.local.dao.home

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.Movies
import com.codeinglogs.local.entity.home.TopRatedMovies

@Dao
interface TopRatedMoviesDao {

    @Insert
    suspend fun insert(movies: TopRatedMovies)

    @Update
    suspend fun update(movies: TopRatedMovies)

    @Delete
    suspend fun delete(movies: TopRatedMovies)

    @Query("SELECT * FROM TopRatedMovies")
    fun loadAllTopRatedMovies() : LiveData<TopRatedMovies>

    @Insert
    fun insertAllTopRatedMovies(vararg movies: TopRatedMovies)

    @Query("SELECT * FROM Movies INNER JOIN TopRatedMovies ON Movies.id == TopRatedMovies.movieId")
    fun getAllTopRatedMovies() : List<Movies>
}