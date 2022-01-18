package com.codeinglogs.local.db


import androidx.room.Database
import androidx.room.RoomDatabase
import com.codeinglogs.local.dao.*
import com.codeinglogs.local.entity.*

@Database(
    entities = [
        Movies::class,
        Persons::class,
        TvShows::class,
        TrendingMovies::class,
        TrendingPersons::class,
        TrendingTvShows::class,
        PopularMovies::class,
        PopularTvShows::class,
        TopRatedMovies::class,
        TopRatedTvShows::class], version = 2, exportSchema = false
)
abstract class MovieHubDatabase : RoomDatabase() {
    abstract fun getMoviesDao(): MoviesDao
    abstract fun getPersonsDao(): PersonsDao
    abstract fun getTrendingPersonsDao(): TrendingPersonsDao
    abstract fun getTvShowsDao(): TvShowsDao
    abstract fun getTrendingMoviesDao(): TrendingMoviesDao
    abstract fun getPopularMoviesDao(): PopularMoviesDao
    abstract fun getTopRatedMoviesDao(): TopRatedMoviesDao
    abstract fun getTrendingTvShowsDao(): TrendingTvShowsDao
    abstract fun getPopularTvShowsDao(): PopularTvShowsDao
    abstract fun getTopRatedTvShowsDao(): TopRatedTvShowsDao
}