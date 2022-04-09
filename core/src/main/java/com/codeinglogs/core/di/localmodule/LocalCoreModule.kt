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
import com.codeinglogs.local.dao.tvshowdetails.credits.TvShowCreditsToCastRelationDao
import com.codeinglogs.local.dao.tvshowdetails.credits.TvShowCreditsToCrewRelationDao
import com.codeinglogs.local.dao.tvshowdetails.image.TvShowBackdropDao
import com.codeinglogs.local.dao.tvshowdetails.image.TvShowImagesToBackdropRelationDao
import com.codeinglogs.local.dao.tvshowdetails.image.TvShowImagesToPosterRelationDao
import com.codeinglogs.local.dao.tvshowdetails.image.TvShowPosterDao
import com.codeinglogs.local.dao.tvshowdetails.info.*
import com.codeinglogs.local.dao.tvshowdetails.review.TvShowReviewRelationDao
import com.codeinglogs.local.dao.tvshowdetails.review.TvShowReviewsDao
import com.codeinglogs.local.dao.tvshowdetails.video.TvShowVideoDao
import com.codeinglogs.local.dao.tvshowdetails.video.TvShowVideoRelationDao
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

    //TvShow Details

    @Singleton
    @Provides
    fun getTvShowCreditsToCastRelationDao(db: MovieHubDatabase): TvShowCreditsToCastRelationDao = db.getTvShowCreditsToCastRelationDao()

    @Singleton
    @Provides
    fun getTvShowCreditsToCrewRelationDao(db: MovieHubDatabase): TvShowCreditsToCrewRelationDao = db.getTvShowCreditsToCrewRelationDao()

    @Singleton
    @Provides
    fun getTvShowBackdropDao(db: MovieHubDatabase): TvShowBackdropDao = db.getTvShowBackdropDao()

    @Singleton
    @Provides
    fun getTvShowImagesToBackdropRelationDao(db: MovieHubDatabase): TvShowImagesToBackdropRelationDao = db.getTvShowImagesToBackdropRelationDao()

    @Singleton
    @Provides
    fun getTvShowImagesToPosterRelationDao(db: MovieHubDatabase): TvShowImagesToPosterRelationDao = db.getTvShowImagesToPosterRelationDao()

    @Singleton
    @Provides
    fun getTvShowPosterDao(db: MovieHubDatabase): TvShowPosterDao = db.getTvShowPosterDao()

    @Singleton
    @Provides
    fun getTvShowGenerDao(db: MovieHubDatabase): TvShowGenreDao = db.getTvShowGenerDao()

    @Singleton
    @Provides
    fun getTvShowInfoResponseDao(db: MovieHubDatabase): TvShowInfoResponseDao = db.getTvShowInfoResponseDao()

    @Singleton
    @Provides
    fun getTvShowInfoToGenerRelationDao(db: MovieHubDatabase): TvShowInfoToGenerRelationDao = db.getTvShowInfoToGenerRelationDao()

    @Singleton
    @Provides
    fun getTvShowInfoToProductionCompaniesRelationDao(db: MovieHubDatabase): TvShowInfoToProductionCompaniesRelationDao = db.getTvShowInfoToProductionCompaniesRelationDao()

    @Singleton
    @Provides
    fun getTvShowProductionCompaniesDao(db: MovieHubDatabase): TvShowProductionCompanyDao = db.getTvShowProductionCompaniesDao()

    @Singleton
    @Provides
    fun getTvShowInfoToSeasonRelationDao(db: MovieHubDatabase): TvShowInfoToSeasonRelationDao = db.getTvShowInfoToSeasonRelationDao()

    @Singleton
    @Provides
    fun getTvShowSeasonDao(db: MovieHubDatabase): TvShowSeasonDao = db.getTvShowSeasonDao()

    @Singleton
    @Provides
    fun getTvShowReviewRelationDao(db: MovieHubDatabase): TvShowReviewRelationDao = db.getTvShowReviewRelationDao()

    @Singleton
    @Provides
    fun getTvShowReviewsDao(db: MovieHubDatabase): TvShowReviewsDao = db.getTvShowReviewsDao()

    @Singleton
    @Provides
    fun getTvShowsVideoDao(db: MovieHubDatabase): TvShowVideoDao = db.getTvShowsVideoDao()

    @Singleton
    @Provides
    fun getTvShowVideoRelationDao(db: MovieHubDatabase): TvShowVideoRelationDao = db.getTvShowVideoRelationDao()
}