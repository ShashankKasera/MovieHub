package com.codeinglogs.core.di.localmodule

import android.content.Context
import androidx.room.Room
import com.codeinglogs.local.constant.ROOM_DB_NAME
import com.codeinglogs.local.dao.*
import com.codeinglogs.local.db.MovieHubDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object LocalCoreModule {

    @Singleton
    @Provides
    @Named("DBName")
    fun getDBName():String=ROOM_DB_NAME

    @Singleton
    @Provides
    fun getRoomDB(@ApplicationContext context: Context, @Named("DBName")name :String) =
        Room.databaseBuilder(context,MovieHubDatabase::class.java,name).build()




    @Singleton
    @Provides
    fun getPersonDao(db: MovieHubDatabase): PersonsDao = db.getPersonsDao()

    @Singleton
    @Provides
    fun getTrendingPersonDao(db: MovieHubDatabase): TrendingPersonsDao = db.getTrendingPersonsDao()

    @Singleton
    @Provides
    fun getMovieDao(db: MovieHubDatabase): MoviesDao = db.getMoviesDao()

    @Singleton
    @Provides
    fun getTrendingMoviesDao(db: MovieHubDatabase): TrendingMoviesDao = db.getTrendingMoviesDao()

    @Singleton
    @Provides
    fun getPopularMoviesDao(db: MovieHubDatabase): PopularMoviesDao = db.getPopularMoviesDao()

    @Singleton
    @Provides
    fun getTopRatedMoviesDao(db: MovieHubDatabase): TopRatedMoviesDao = db.getTopRatedMoviesDao()

    @Singleton
    @Provides
    fun getTvShowDao(db: MovieHubDatabase): TvShowsDao = db.getTvShowsDao()

    @Singleton
    @Provides
    fun getTrendingTvShowsDao(db: MovieHubDatabase): TrendingTvShowsDao = db.getTrendingTvShowsDao()

    @Singleton
    @Provides
    fun getPopularTvShowsDao(db: MovieHubDatabase): PopularTvShowsDao = db.getPopularTvShowsDao()

    @Singleton
    @Provides
    fun getTopRatedTvShowsDao(db: MovieHubDatabase): TopRatedTvShowsDao = db.getTopRatedTvShowsDao()

}