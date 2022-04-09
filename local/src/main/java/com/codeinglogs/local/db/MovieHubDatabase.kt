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
import com.codeinglogs.local.dao.tvshowdetails.credits.TvShowCreditsToCastRelationDao
import com.codeinglogs.local.dao.tvshowdetails.credits.TvShowCreditsToCrewRelationDao
import com.codeinglogs.local.dao.tvshowdetails.image.TvShowBackdropDao
import com.codeinglogs.local.dao.tvshowdetails.image.TvShowImagesToBackdropRelationDao
import com.codeinglogs.local.dao.tvshowdetails.image.TvShowImagesToPosterRelationDao
import com.codeinglogs.local.dao.tvshowdetails.image.TvShowPosterDao
import com.codeinglogs.local.dao.tvshowdetails.info.*
import com.codeinglogs.local.dao.tvshowdetails.info.TvShowInfoToSeasonRelationDao
import com.codeinglogs.local.dao.tvshowdetails.review.TvShowReviewRelationDao
import com.codeinglogs.local.dao.tvshowdetails.review.TvShowReviewsDao
import com.codeinglogs.local.dao.tvshowdetails.video.TvShowVideoDao
import com.codeinglogs.local.dao.tvshowdetails.video.TvShowVideoRelationDao
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
import com.codeinglogs.local.entity.tvshowdetails.credits.TvShowCreditsToCastRelation
import com.codeinglogs.local.entity.tvshowdetails.credits.TvShowCreditsToCrewRelation
import com.codeinglogs.local.entity.tvshowdetails.image.TvShowBackdrop
import com.codeinglogs.local.entity.tvshowdetails.image.TvShowImagesToBackdropRelation
import com.codeinglogs.local.entity.tvshowdetails.image.TvShowImagesToTvShowPosterRelation
import com.codeinglogs.local.entity.tvshowdetails.image.TvShowPoster
import com.codeinglogs.local.entity.tvshowdetails.info.*
import com.codeinglogs.local.entity.tvshowdetails.reviews.TvShowReviewRelation
import com.codeinglogs.local.entity.tvshowdetails.reviews.TvShowReviews
import com.codeinglogs.local.entity.tvshowdetails.video.TvShowVideo
import com.codeinglogs.local.entity.tvshowdetails.video.TvShowVideoRelation

@Database(
    entities = [

        //Home
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


        //Movie Details
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
        MovieVideoRelation::class,


        //TvShow Details
        TvShowCreditsToCastRelation::class,
        TvShowCreditsToCrewRelation::class,
        TvShowBackdrop::class,
        TvShowImagesToBackdropRelation::class,
        TvShowImagesToTvShowPosterRelation::class,
        TvShowPoster::class,
        TvShowGenre::class,
        TvShowInfoResponse::class,
        TvShowInfoToGenerRelation::class,
        TvShowInfoToProductionCompaniesRelation::class,
        TvShowInfoToSeasonRelation::class,
        TvShowProductionCompany::class,
        TvShowSeason::class,
        TvShowReviews::class,
        TvShowReviewRelation::class,
        TvShowVideo::class,
        TvShowVideoRelation::class,
        ], version = 4, exportSchema = false
)
abstract class MovieHubDatabase : RoomDatabase() {

    //Home
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

    //Movie Details
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


    //TvShow Details
    abstract fun getTvShowCreditsToCastRelationDao(): TvShowCreditsToCastRelationDao
    abstract fun getTvShowCreditsToCrewRelationDao(): TvShowCreditsToCrewRelationDao
    abstract fun getTvShowBackdropDao(): TvShowBackdropDao
    abstract fun getTvShowImagesToBackdropRelationDao(): TvShowImagesToBackdropRelationDao
    abstract fun getTvShowImagesToPosterRelationDao(): TvShowImagesToPosterRelationDao
    abstract fun getTvShowPosterDao(): TvShowPosterDao
    abstract fun getTvShowGenerDao(): TvShowGenreDao
    abstract fun getTvShowInfoResponseDao(): TvShowInfoResponseDao
    abstract fun getTvShowInfoToGenerRelationDao(): TvShowInfoToGenerRelationDao
    abstract fun getTvShowInfoToProductionCompaniesRelationDao(): TvShowInfoToProductionCompaniesRelationDao
    abstract fun getTvShowInfoToSeasonRelationDao(): TvShowInfoToSeasonRelationDao
    abstract fun getTvShowProductionCompaniesDao(): TvShowProductionCompanyDao
    abstract fun getTvShowSeasonDao(): TvShowSeasonDao
    abstract fun getTvShowReviewRelationDao(): TvShowReviewRelationDao
    abstract fun getTvShowReviewsDao(): TvShowReviewsDao
    abstract fun getTvShowsVideoDao(): TvShowVideoDao
    abstract fun getTvShowVideoRelationDao(): TvShowVideoRelationDao
}