package com.codeinglogs.local.db


import androidx.room.Database
import androidx.room.RoomDatabase
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
import com.codeinglogs.local.entity.*
import com.codeinglogs.local.entity.home.*
import com.codeinglogs.local.entity.moviedetail.credits.MovieCreditsToCastRelation
import com.codeinglogs.local.entity.moviedetail.credits.MovieCreditsToCrewRelation
import com.codeinglogs.local.entity.moviedetail.image.MovieBackdrop
import com.codeinglogs.local.entity.moviedetail.image.MovieImagesToBackdropRelation
import com.codeinglogs.local.entity.moviedetail.image.MovieImagesToMoviePosterRelation
import com.codeinglogs.local.entity.moviedetail.image.MoviePoster
import com.codeinglogs.local.entity.moviedetail.info.*
import com.codeinglogs.local.entity.moviedetail.reviews.MovieReviewRelation
import com.codeinglogs.local.entity.moviedetail.reviews.MovieReviews
import com.codeinglogs.local.entity.moviedetail.video.MovieVideo
import com.codeinglogs.local.entity.moviedetail.video.MovieVideoRelation

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
        TopRatedTvShows::class,


        MovieCreditsToCastRelation::class,
        MovieCreditsToCrewRelation::class,
        MovieBackdrop::class,
        MovieImagesToBackdropRelation::class,
        MovieImagesToMoviePosterRelation::class,
        MoviePoster::class,
        MovieGener::class,
        MovieInfoResponse::class,
        MovieInfoToGenerRelation::class,
        MovieInfoToProductionCompaniesRelation::class,
        MovieProductionCompanies::class,
        MovieReviews::class,
        MovieReviewRelation::class,
        MovieVideo::class,
        MovieVideoRelation::class,       ], version = 3, exportSchema = false
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

    abstract fun getMovieCreditsToCastRelationDao(): MovieCreditsToCastRelationDao
    abstract fun getMovieCreditsToCrewRelationDao(): MovieCreditsToCrewRelationDao
    abstract fun getMovieBackdropDao(): MovieBackdropDao
    abstract fun getMovieImagesToBackdropRelationDao(): MovieImagesToBackdropRelationDao
    abstract fun getMovieImagesToPosterRelationDao(): MovieImagesToPosterRelationDao
    abstract fun getMoviePosterDao(): MoviePosterDao
    abstract fun getMovieGenerDao(): MovieGenerDao
    abstract fun getMovieInfoResponseDao(): MovieInfoResponseDao
    abstract fun getMovieInfoToGenerRelationDao(): MovieInfoToGenerRelationDao
    abstract fun getMovieInfoToProductionCompaniesRelationDao(): MovieInfoToProductionCompaniesRelationDao
    abstract fun getMovieProductionCompaniesDao(): MovieProductionCompaniesDao
    abstract fun getMovieReviewRelationDao(): MovieReviewRelationDao
    abstract fun getMovieReviewsDao(): MovieReviewsDao
    abstract fun getMoviesVideoDao(): MoviesVideoDao
    abstract fun getMovieVideoRelationDao(): MovieVideoRelationDao
}