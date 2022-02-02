package com.codeinglogs.local.dao.home

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.Movies
import com.codeinglogs.local.entity.home.PopularMovies

@Dao
interface PopularMoviesDao {

    @Insert
    suspend fun insert(movies: PopularMovies)

    @Update
    suspend fun update(movies: PopularMovies)

    @Delete
    suspend fun delete(movies: PopularMovies)

    @Query("SELECT * FROM PopularMovies")
    fun loadAllPopularMovies() : LiveData<PopularMovies>

    @Insert
    fun insertAllPopularMovies(vararg movies: PopularMovies)

    @Query("SELECT * FROM Movies INNER JOIN PopularMovies ON Movies.id == PopularMovies.movieId")
    fun getAllPopularMovies() : List<Movies>
}