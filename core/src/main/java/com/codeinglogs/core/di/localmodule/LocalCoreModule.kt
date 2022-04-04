package com.codeinglogs.core.di.localmodule

import android.content.Context
import androidx.room.Room
import com.codeinglogs.local.constant.ROOM_DB_NAME
import com.codeinglogs.local.dao.*
import com.codeinglogs.local.dao.home.*
import com.codeinglogs.local.dao.moviedetail.credits.MovieCreditsToCastRelationDao
import com.codeinglogs.local.dao.moviedetail.credits.MovieCreditsToCrewRelationDao
import com.codeinglogs.local.dao.moviedetail.image.MovieBackdropDao
import com.codeinglogs.local.dao.moviedetail.image.MovieImagesToBackdropRelationDao
import com.codeinglogs.local.dao.moviedetail.image.MovieImagesToPosterRelationDao
import com.codeinglogs.local.dao.moviedetail.image.MoviePosterDao
import com.codeinglogs.local.dao.moviedetail.info.*
import com.codeinglogs.local.dao.moviedetail.reviews.MovieReviewRelationDao
import com.codeinglogs.local.dao.moviedetail.reviews.MovieReviewsDao
import com.codeinglogs.local.dao.moviedetail.video.MovieVideoRelationDao
import com.codeinglogs.local.dao.moviedetail.video.MoviesVideoDao
import com.codeinglogs.local.db.MovieHubDatabase
import com.codeinglogs.local.entity.moviedetail.credits.MovieCreditsToCastRelation
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
        Room.databaseBuilder(context,MovieHubDatabase::class.java,name).fallbackToDestructiveMigration().build()




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

    @Singleton
    @Provides
    fun getMovieCreditsToCastRelationDao(db: MovieHubDatabase): MovieCreditsToCastRelationDao = db.getMovieCreditsToCastRelationDao()

    @Singleton
    @Provides
    fun getMovieCreditsToCrewRelationDao(db: MovieHubDatabase): MovieCreditsToCrewRelationDao = db.getMovieCreditsToCrewRelationDao()

    @Singleton
    @Provides
    fun getMovieBackdropDao(db: MovieHubDatabase): MovieBackdropDao = db.getMovieBackdropDao()

    @Singleton
    @Provides
    fun getMovieImagesToBackdropRelationDao(db: MovieHubDatabase): MovieImagesToBackdropRelationDao = db.getMovieImagesToBackdropRelationDao()

    @Singleton
    @Provides
    fun getMovieImagesToPosterRelationDao(db: MovieHubDatabase): MovieImagesToPosterRelationDao = db.getMovieImagesToPosterRelationDao()

    @Singleton
    @Provides
    fun getMoviePosterDao(db: MovieHubDatabase): MoviePosterDao = db.getMoviePosterDao()

    @Singleton
    @Provides
    fun getMovieGenerDao(db: MovieHubDatabase): MovieGenerDao = db.getMovieGenerDao()

    @Singleton
    @Provides
    fun getMovieInfoResponseDao(db: MovieHubDatabase): MovieInfoResponseDao = db.getMovieInfoResponseDao()

    @Singleton
    @Provides
    fun getMovieInfoToGenerRelationDao(db: MovieHubDatabase): MovieInfoToGenerRelationDao = db.getMovieInfoToGenerRelationDao()

    @Singleton
    @Provides
    fun getMovieInfoToProductionCompaniesRelationDao(db: MovieHubDatabase): MovieInfoToProductionCompaniesRelationDao = db.getMovieInfoToProductionCompaniesRelationDao()

    @Singleton
    @Provides
    fun getMovieProductionCompaniesDao(db: MovieHubDatabase): MovieProductionCompaniesDao = db.getMovieProductionCompaniesDao()

    @Singleton
    @Provides
    fun getMovieReviewRelationDao(db: MovieHubDatabase): MovieReviewRelationDao = db.getMovieReviewRelationDao()

    @Singleton
    @Provides
    fun getMovieReviewsDao(db: MovieHubDatabase): MovieReviewsDao = db.getMovieReviewsDao()

    @Singleton
    @Provides
    fun getMoviesVideoDao(db: MovieHubDatabase): MoviesVideoDao = db.getMoviesVideoDao()

    @Singleton
    @Provides
    fun getMovieVideoRelationDao(db: MovieHubDatabase): MovieVideoRelationDao = db.getMovieVideoRelationDao()

}