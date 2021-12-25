package com.codeinglogs.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.Movies
import com.codeinglogs.local.entity.TrendingMovies

@Dao
interface TrendingMoviesDao {
    @Insert
    suspend fun insert(movies: TrendingMovies)

    @Update
    suspend fun update(movies: TrendingMovies)

    @Delete
    suspend fun delete(movies: TrendingMovies)

    @Query("SELECT * FROM TrendingMovies")
    fun loadAllTrendingMovies() : LiveData<TrendingMovies>

    @Insert
    fun insertAllTrendingMovies(vararg movies: TrendingMovies)

    @Query("SELECT * FROM Movies INNER JOIN TrendingMovies ON Movies.id == TrendingMovies.movieId")
    fun getAllTrendingMovie() : List<Movies>
}