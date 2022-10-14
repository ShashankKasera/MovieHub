package com.codeinglogs.local.datarepositoryimp

import android.util.Log
import com.codeinglogs.data.model.movies.moviedetail.MovieDetailsDisplay
import com.codeinglogs.data.model.movies.moviedetail.credits.MovieCreditsResponse
import com.codeinglogs.data.model.movies.moviedetail.images.MovieIMagesResponse
import com.codeinglogs.data.model.movies.moviedetail.reviews.MovieReviewsResponse
import com.codeinglogs.data.model.movies.moviedetail.videos.MovieVideosResponse
import com.codeinglogs.local.entity.mylist.movie.MyMovieList
import com.codeinglogs.local.entity.mylist.movie.MyMovieListDetails
import com.codeinglogs.data.repository.moviedetails.LocalMovieDetailData
import com.codeinglogs.local.dao.PersonsDao
import com.codeinglogs.local.dao.bookmark.BookmarkMoviesDao
import com.codeinglogs.local.dao.maylist.movie.MyMovieListDao
import com.codeinglogs.local.dao.maylist.movie.MyMovieListDetailsDao
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
import com.codeinglogs.local.entity.bookmark.BookmarkMovies
import com.codeinglogs.local.entity.moviedetail.credits.toLocalMovieCreditsToCastRelationList
import com.codeinglogs.local.entity.moviedetail.credits.toLocalMovieCreditsToCrewRelationList
import com.codeinglogs.local.entity.moviedetail.image.*
import com.codeinglogs.local.entity.moviedetail.info.*
import com.codeinglogs.local.entity.moviedetail.reviews.toDataMovieReviews
import com.codeinglogs.local.entity.moviedetail.reviews.toLocalMovieReviewsList
import com.codeinglogs.local.entity.moviedetail.reviews.toLocalMovieReviewsRelationList
import com.codeinglogs.local.entity.moviedetail.video.toDataMovieVideo
import com.codeinglogs.local.entity.moviedetail.video.toLocalMovieVideo
import com.codeinglogs.local.entity.moviedetail.video.toLocalMovieVideoRelationList
import com.codeinglogs.local.entity.mylist.movie.toDataMyMovieList
import com.codeinglogs.local.entity.mylist.movie.toDataMyMovieListDetailsList
import com.codeinglogs.local.entity.toDataPersons
import com.codeinglogs.local.entity.toLocalPersons
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

import  com.codeinglogs.data.model.movies.mylist.MyMovieList as DataMyMovieList
import  com.codeinglogs.data.model.movies.mylist.MyMovieListDetails as DataMyMovieListDetails
class LocalMovieDetailsDataRepositoryImp  @Inject constructor (
    private val personsDao: PersonsDao,
    private val movieCreditsToCastRelationDao: MovieCreditsToCastRelationDao,
    private val movieCreditsToCrewRelationDao: MovieCreditsToCrewRelationDao,
    private val movieBackdropDao: MovieBackdropDao,
    private val movieImagesToBackdropRelationDao: MovieImagesToBackdropRelationDao,
    private val moviePosterDao: MoviePosterDao,
    private val movieImagesToPosterRelationDao: MovieImagesToPosterRelationDao,
    private val movieGenerDao: MovieGenerDao,
    private val movieInfoToGenerRelationDao: MovieInfoToGenerRelationDao,
    private val movieProductionCompaniesDao: MovieProductionCompaniesDao,
    private val movieInfoToProductionCompaniesRelationDao: MovieInfoToProductionCompaniesRelationDao,
    private val movieReviewsDao: MovieReviewsDao,
    private val movieReviewRelationDao: MovieReviewRelationDao,
    private val moviesVideoDao: MoviesVideoDao,
    private val movieVideoRelationDao: MovieVideoRelationDao,
    private val movieInfoResponseDao : MovieInfoResponseDao,
    private val movieBookmarkMoviesDao: BookmarkMoviesDao,
    private val myMovieListDao: MyMovieListDao,
    private val myMovieListDetailsDao: MyMovieListDetailsDao,
    ): LocalMovieDetailData {
    override suspend fun isMovieDetailExist(movieId: String): Boolean {
        return movieInfoResponseDao.isMovieInfoIsExist(movieId.toInt())
    }

    override suspend fun insertMovieDetail(MovieDetails: MovieDetailsDisplay) {
        coroutineScope {
            launch {
                movieInfoResponseDao.insertAllMovieInfoResponse(
                    MovieDetails.movieInfoResponse.toLocalMovieInfo()
                )
                personsDao.insertAllPersons(
                    *MovieDetails.movieCreditsResponse.cast.toLocalPersons().toTypedArray()
                )
                personsDao.insertAllPersons(
                    *MovieDetails.movieCreditsResponse.crew.toLocalPersons().toTypedArray()
                )
                movieGenerDao.insertAllMovieGener(
                    *MovieDetails.movieInfoResponse.genres.toLocalMovieGener().toTypedArray()
                )
                movieProductionCompaniesDao.insertAllMovieProductionCompanies(
                    *MovieDetails.movieInfoResponse.production_companies.toLocalMovieProductionCompanies().toTypedArray()
                )
                movieBackdropDao.insertAllMovieBackdrop(
                    *MovieDetails.movieIMagesResponse.backdrops.toLocalMovieBackdropList().toTypedArray()
                )
                moviePosterDao.insertAllMoviePoster(
                    *MovieDetails.movieIMagesResponse.posters.toLocalMoviePosterList().toTypedArray()
                )
                movieReviewsDao.insertAllMovieReviews(
                    *MovieDetails.movieReviewsResponse.results.toLocalMovieReviewsList().toTypedArray()
                )
                moviesVideoDao.insertAllMovieVideo(
                    *MovieDetails.MovieVideosResponse.results.toLocalMovieVideo().toTypedArray()
                )
            }
        }

        coroutineScope {
            launch {
                movieCreditsToCastRelationDao.insertAllMovieCreditsToCastRelation(
                    *MovieDetails.movieCreditsResponse.cast.toLocalMovieCreditsToCastRelationList(
                        MovieDetails.movieInfoResponse.id.toString()
                    ).toTypedArray()
                )
                movieCreditsToCrewRelationDao.insertAllMovieCreditsToCrewRelation(
                    *MovieDetails.movieCreditsResponse.crew.toLocalMovieCreditsToCrewRelationList(
                        MovieDetails.movieInfoResponse.id.toString()
                    ).toTypedArray()
                )
                movieImagesToBackdropRelationDao.insertAllMovieImagesToBackdropRelation(
                    *MovieDetails.movieIMagesResponse.backdrops.toLocalMovieImagesToBackdropRelationList(
                        MovieDetails.movieInfoResponse.id.toString()
                    ).toTypedArray()
                )
                movieImagesToPosterRelationDao.insertAllMovieImagesToMoviePosterRelation(
                    *MovieDetails.movieIMagesResponse.posters.toLocalMovieImagesToMoviePosterRelationList(
                        MovieDetails.movieInfoResponse.id.toString()
                    ).toTypedArray()
                )
                movieInfoToGenerRelationDao.insertAllMovieInfoToGenerRelation(
                    *MovieDetails.movieInfoResponse.genres.toLocalMovieInfoToGenerRelationList(
                        MovieDetails.movieInfoResponse.id.toString()
                    ).toTypedArray()
                )
                movieInfoToProductionCompaniesRelationDao.insertAllMovieInfoToProductionCompaniesRelation(
                    *MovieDetails.movieInfoResponse.production_companies.toLocalMovieInfoToProductionCompaniesRelationList(
                        MovieDetails.movieInfoResponse.id.toString()
                    ).toTypedArray()
                )
                movieReviewRelationDao.insertAllMovieReviewRelation(
                    *MovieDetails.movieReviewsResponse.results.toLocalMovieReviewsRelationList(
                        MovieDetails.movieInfoResponse.id.toString()
                    ).toTypedArray()
                )
                movieVideoRelationDao.insertAlMovieVideoRelation(
                    *MovieDetails.MovieVideosResponse.results.toLocalMovieVideoRelationList(
                        MovieDetails.movieInfoResponse.id.toString()
                    ).toTypedArray()
                )
            }
        }
    }

    override suspend fun getMovieDetail(id: String): MovieDetailsDisplay {
        return coroutineScope{

            val movieCreditsResponse = async {
                val movieCast = async { movieCreditsToCastRelationDao.getMovieCreditsToCastRelation(id.toInt()) }
                val movieCrew = async { movieCreditsToCrewRelationDao.getMovieCreditsToCrewRelation(id.toInt()) }
                MovieCreditsResponse(id.toInt(),movieCast.await().toDataPersons(),movieCrew.await().toDataPersons())
            }
            val movieImageResponse = async {
                val movieBackdrop = async { movieImagesToBackdropRelationDao.getMovieImagesToBackdropRelation(id.toInt()) }
                val moviePoster = async { movieImagesToPosterRelationDao.getMovieImagesToMoviePosterRelation(id.toInt()) }
                MovieIMagesResponse(id.toInt(),movieBackdrop.await().toDataMovieBackdrop(),moviePoster.await().toDataMoviePoster())
            }
            val movieInfoResponse = async {
                val movieInfoResponse = async { movieInfoResponseDao.getMovieInfoResponse(id.toInt())  }
                val movieGeners = async { movieInfoToGenerRelationDao.getMovieInfoToGenerRelation(id.toInt()) }
                val movieProductionCompanies = async { movieInfoToProductionCompaniesRelationDao.getMovieInfoToProductionCompaniesRelation(id.toInt()) }
                movieInfoResponse.await().toDataMovieInfo(movieProductionCompanies.await(),movieGeners.await())
            }
            val movieReviewsResponse = async {
                val movieReviews = async { movieReviewRelationDao.getMovieReviewRelation(id.toInt()) }
                MovieReviewsResponse(id.toInt(),movieReviews.await().toDataMovieReviews())
            }
            val movieVideoResponse = async {
                val movieVideo = async { movieVideoRelationDao.getMovieVideoRelation(id.toInt()) }
                MovieVideosResponse(id.toInt(),movieVideo.await().toDataMovieVideo())
            }

            Log.i("gkjwg", "getMovieDetail movieCreditsResponse : ${movieCreditsResponse.await()}")
            Log.i("gkjwg", "getMovieDetail movieImageResponse : ${movieImageResponse.await()}")
            Log.i("gkjwg", "getMovieDetail movieInfoResponse : ${movieInfoResponse.await()}")
            Log.i("gkjwg", "getMovieDetail movieReviewsResponse : ${movieReviewsResponse.await()}")
            Log.i("gkjwg", "getMovieDetail movieVideoResponse : ${movieVideoResponse.await()}")

            MovieDetailsDisplay(movieCreditsResponse.await(),
                movieImageResponse.await(),
                movieInfoResponse.await(),
                movieReviewsResponse.await(),
                movieVideoResponse.await(),
            )
        }

    }

    override suspend fun isBookmarkMoviesIsExist(movieId: Long) : Boolean{
       return movieBookmarkMoviesDao.isBookmarkMoviesIsExist(movieId = movieId)
    }

//    override suspend fun isBookmarkMoviesExist(bookmarkId: Long): Boolean {
//        return movieBookmarkMoviesDao.isBookmarkMoviesIsExist(bookmarkId)
//    }


    override suspend fun updateBookmarkMovies(bookmarkId: Long) {
        movieBookmarkMoviesDao.insert(BookmarkMovies(0,bookmarkId))
    }

    override suspend fun insertMyMoviesList(list: String): Long {
        return myMovieListDao.insert(MyMovieList(0,list))
    }

    override suspend fun insertMyMoviesListDetails(myMoviesListId: Long, movieId: Long): Long {
        return myMovieListDetailsDao.insert(MyMovieListDetails(0,myMoviesListId,movieId))
    }

    override suspend fun getAllMyMoviesList(): List<DataMyMovieList> {
        return myMovieListDao.getAllMayMovieList().toDataMyMovieList()
    }

    override suspend fun getMyMoviesList(): List<DataMyMovieList> {
        return myMovieListDao.getAllMayMovieList().toDataMyMovieList()
    }

    override suspend fun getMyMoviesListDetails(
        myMovieListId: Long,
        movieId: String
    ): List<DataMyMovieListDetails> {
        return myMovieListDetailsDao.getMyMovieListDetails(myMovieListId, movieId.toLong()).toDataMyMovieListDetailsList()
    }

    override suspend fun getAllMyMoviesListDetails(): List<DataMyMovieListDetails> {
        return myMovieListDetailsDao.getAllMyMovieListDetails().toDataMyMovieListDetailsList()
    }


}