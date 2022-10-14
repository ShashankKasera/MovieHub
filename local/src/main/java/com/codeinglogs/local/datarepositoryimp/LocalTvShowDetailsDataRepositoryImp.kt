package com.codeinglogs.local.datarepositoryimp

import android.util.Log
import com.codeinglogs.data.model.tvshow.tvshowdetails.TvShowDetailsDisplay
import com.codeinglogs.data.model.tvshow.tvshowdetails.credits.TvShowCreditsResponse
import com.codeinglogs.data.model.tvshow.tvshowdetails.image.TvShowImageResponse
import com.codeinglogs.data.model.tvshow.tvshowdetails.reviews.TvShowReviewsResponse
import com.codeinglogs.data.model.tvshow.tvshowdetails.video.TvShowsVideosResponse
import com.codeinglogs.data.repository.tvshowetails.LocalTvShowDetailData
import com.codeinglogs.local.dao.PersonsDao
import com.codeinglogs.local.dao.bookmark.BookmarkMoviesDao
import com.codeinglogs.local.dao.bookmark.BookmarkTvShowsDao
import com.codeinglogs.local.dao.moviedetail.info.MovieGenerDao
import com.codeinglogs.local.dao.moviedetail.info.MovieInfoToGenerRelationDao
import com.codeinglogs.local.dao.moviedetail.info.MovieProductionCompaniesDao
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
import com.codeinglogs.local.entity.moviedetail.credits.toLocalMovieCreditsToCrewRelationList
import com.codeinglogs.local.entity.toDataPersons
import com.codeinglogs.local.entity.toLocalPersons
import com.codeinglogs.local.entity.tvshowdetails.credits.toLocalTvShowCreditsToCastRelationList
import com.codeinglogs.local.entity.tvshowdetails.credits.toLocalTvShowCreditsToCrewRelationList
import com.codeinglogs.local.entity.tvshowdetails.image.*
import com.codeinglogs.local.entity.tvshowdetails.info.*
import com.codeinglogs.local.entity.tvshowdetails.reviews.toDataTvShowReviews
import com.codeinglogs.local.entity.tvshowdetails.reviews.toLocalTvShowReviewsList
import com.codeinglogs.local.entity.tvshowdetails.reviews.toLocalTvShowReviewsRelationList
import com.codeinglogs.local.entity.tvshowdetails.video.toDataTvShowVideo
import com.codeinglogs.local.entity.tvshowdetails.video.toLocalTvShowVideo
import com.codeinglogs.local.entity.tvshowdetails.video.toLocalTvShowVideoRelationList

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocalTvShowDetailsDataRepositoryImp @Inject constructor (
    private val personsDao: PersonsDao,
    private val tvShowCreditsToCastRelationDao: TvShowCreditsToCastRelationDao,
    private val tvShowCreditsToCrewRelationDao: TvShowCreditsToCrewRelationDao,
    private val tvShowBackdropDao: TvShowBackdropDao,
    private val tvShowImagesToBackdropRelationDao: TvShowImagesToBackdropRelationDao,
    private val tvShowPosterDao: TvShowPosterDao,
    private val tvShowImagesToPosterRelationDao: TvShowImagesToPosterRelationDao,
    private val tvShowGenerDao: TvShowGenreDao,
    private val tvShowInfoToGenerRelationDao: TvShowInfoToGenerRelationDao,
    private val tvShowProductionCompaniesDao: TvShowProductionCompanyDao,
    private val tvShowSeasonDao: TvShowSeasonDao,
    private val tvShowInfoToSeasonRelationDao: TvShowInfoToSeasonRelationDao,
    private val tvShowInfoToProductionCompaniesRelationDao: TvShowInfoToProductionCompaniesRelationDao,
    private val tvShowReviewsDao: TvShowReviewsDao,
    private val tvShowReviewRelationDao: TvShowReviewRelationDao,
    private val tvShowsVideoDao: TvShowVideoDao,
    private val tvShowVideoRelationDao: TvShowVideoRelationDao,
    private val tvShowInfoResponseDao : TvShowInfoResponseDao,
    private val bookmarkTvShowsDao: BookmarkTvShowsDao
): LocalTvShowDetailData {
    override suspend fun getTvShowDetail(id: String): TvShowDetailsDisplay {
        return coroutineScope{

            val tvShowCreditsResponse = async {
                val tvShowCast = async { tvShowCreditsToCastRelationDao.getTvShowCreditsToCastRelation(id.toInt()) }
                val tvShowCrew = async { tvShowCreditsToCrewRelationDao.getTvShowCreditsToCrewRelation(id.toInt()) }
                TvShowCreditsResponse(id.toInt(),tvShowCast.await().toDataPersons(),tvShowCrew.await().toDataPersons())
            }
            val tvShowImageResponse = async {
                val tvShowBackdrop = async { tvShowImagesToBackdropRelationDao.getTvShowImagesToBackdropRelation(id.toInt()) }
                val tvShowPoster = async { tvShowImagesToPosterRelationDao.getTvShowImagesToTvShowPosterRelation(id.toInt()) }
                TvShowImageResponse(id.toInt(),tvShowBackdrop.await().toDataTvShowBackdrop(),tvShowPoster.await().toDataTvShowPoster())
            }
            val tvShowInfoResponse = async {
                val tvShowInfoResponse = async { tvShowInfoResponseDao.getTvShowInfoResponse(id.toInt())  }
                val tvShowGeners = async { tvShowInfoToGenerRelationDao.getTvShowInfoToGenerRelation(id.toInt()) }
                val tvShowProductionCompanies = async { tvShowInfoToProductionCompaniesRelationDao.getTvShowInfoToProductionCompaniesRelation(id.toInt()) }
                val tvShowSeason = async {  tvShowInfoToSeasonRelationDao.getTvShowInfoToSeasonRelation(id.toInt()) }
                tvShowInfoResponse.await().toDataTvShowInfo(tvShowProductionCompanies.await(),tvShowGeners.await(),tvShowSeason.await())
            }
            val tvShowReviewsResponse = async {
                val tvShowReviews = async { tvShowReviewRelationDao.getTvShowReviewRelation(id.toInt()) }
                TvShowReviewsResponse(id.toInt(),tvShowReviews.await().toDataTvShowReviews(),)
            }
            val tvShowVideoResponse = async {
                val tvShowVideo = async { tvShowVideoRelationDao.getTvShowVideoRelation(id.toInt()) }
                TvShowsVideosResponse(id.toInt(),tvShowVideo.await().toDataTvShowVideo())
            }

            Log.i("gkjwg", "getTvShowDetail tvShowCreditsResponse : ${tvShowCreditsResponse.await()}")
            Log.i("gkjwg", "getTvShowDetail tvShowImageResponse : ${tvShowImageResponse.await()}")
            Log.i("gkjwg", "getTvShowDetail tvShowInfoResponse : ${tvShowInfoResponse.await()}")
            Log.i("gkjwg", "getTvShowDetail tvShowReviewsResponse : ${tvShowReviewsResponse.await()}")
            Log.i("gkjwg", "getTvShowDetail tvShowVideoResponse : ${tvShowVideoResponse.await()}")

            TvShowDetailsDisplay(
                tvShowCreditsResponse.await(),
                tvShowImageResponse.await(),
                tvShowInfoResponse.await(),
                tvShowReviewsResponse.await(),
                tvShowVideoResponse.await())
        }

    }

    override suspend fun isTvShowDetailExist(tvShowId: String): Boolean {
        return tvShowInfoResponseDao.isTvShowInfoIsExist(tvShowId.toInt())
    }

    override suspend fun insertTvShowDetail(TvShowDetails: TvShowDetailsDisplay) {
        coroutineScope {
            launch {
                tvShowInfoResponseDao.insertAllTvShowInfoResponse(TvShowDetails.tvShowInfoResponse.toLocalTvShowInfo())
                personsDao.insertAllPersons(*TvShowDetails.tvShowCreditsResponse.cast.toLocalPersons().toTypedArray())
                personsDao.insertAllPersons(*TvShowDetails.tvShowCreditsResponse.crew.toLocalPersons().toTypedArray())
                tvShowGenerDao.insertAllTvShowGenre(*TvShowDetails.tvShowInfoResponse.genres.toLocalTvShowGenre().toTypedArray())
                tvShowProductionCompaniesDao.insertAllTvShowProductionCompany(*TvShowDetails.tvShowInfoResponse.production_companies.toLocalTvShowProductionCompany().toTypedArray())
                tvShowSeasonDao.insertAllTvShowSeason(*TvShowDetails.tvShowInfoResponse.seasons.toLocalTvShowSeason().toTypedArray())
                tvShowBackdropDao.insertAllTvShowBackdrop(*TvShowDetails.tvShowImagesResponse.backdrops.toLocalTvShowBackdropList().toTypedArray())
                tvShowPosterDao.insertAllTvShowPoster(*TvShowDetails.tvShowImagesResponse.posters.toLocalTvShowPosterList().toTypedArray())
                tvShowReviewsDao.insertAllTvShowReviews(*TvShowDetails.tvShowReviewsResponse.results.toLocalTvShowReviewsList().toTypedArray())
                tvShowsVideoDao.insertAllTvShowVideo(*TvShowDetails.tvShowVideosResponse.results.toLocalTvShowVideo().toTypedArray())
            }
        }

        coroutineScope {
            launch {
                tvShowCreditsToCastRelationDao.insertAllTvShowCreditsToCastRelation(*TvShowDetails.tvShowCreditsResponse.cast.toLocalTvShowCreditsToCastRelationList(TvShowDetails.tvShowInfoResponse.id.toString()).toTypedArray())
                tvShowCreditsToCrewRelationDao.insertAllTvShowCreditsToCrewRelation(*TvShowDetails.tvShowCreditsResponse.crew.toLocalTvShowCreditsToCrewRelationList(TvShowDetails.tvShowInfoResponse.id.toString()).toTypedArray())
                tvShowImagesToBackdropRelationDao.insertAllTvShowImagesToBackdropRelation(*TvShowDetails.tvShowImagesResponse.backdrops.toLocalTvShowImagesToBackdropRelationList(TvShowDetails.tvShowInfoResponse.id.toString()).toTypedArray())
                tvShowImagesToPosterRelationDao.insertAllTvShowImagesToTvShowPosterRelation(*TvShowDetails.tvShowImagesResponse.posters.toLocalTvShowImagesToMoviePosterRelationList(TvShowDetails.tvShowInfoResponse.id.toString()).toTypedArray())
                tvShowInfoToGenerRelationDao.insertAllTvShowInfoToGenerRelation(*TvShowDetails.tvShowInfoResponse.genres.toLocalTvShowInfoToGenerRelationList(TvShowDetails.tvShowInfoResponse.id.toString()).toTypedArray())
                tvShowInfoToProductionCompaniesRelationDao.insertAllTvShowInfoToProductionCompaniesRelation(*TvShowDetails.tvShowInfoResponse.production_companies.toLocalTvShowInfoToProductionCompaniesRelationList(TvShowDetails.tvShowInfoResponse.id.toString()).toTypedArray())
                tvShowInfoToSeasonRelationDao.insertAllTvShowInfoToSeasonRelation(*TvShowDetails.tvShowInfoResponse.seasons.toLocalTvShowInfoToSeasonRelationList(TvShowDetails.tvShowInfoResponse.id.toString()).toTypedArray())
                tvShowReviewRelationDao.insertAllTvShowReviewRelation(*TvShowDetails.tvShowReviewsResponse.results.toLocalTvShowReviewsRelationList(TvShowDetails.tvShowInfoResponse.id.toString()).toTypedArray())
                tvShowVideoRelationDao.insertAlTvShowVideoRelation(*TvShowDetails.tvShowVideosResponse.results.toLocalTvShowVideoRelationList(TvShowDetails.tvShowInfoResponse.id.toString()).toTypedArray())
            }
        }
    }

    override suspend fun isBookmarkTvShowsIsExist(tvShowId: Long): Boolean {
        return bookmarkTvShowsDao.isBookmarkTvShowsIsExist(tvShowId =tvShowId )
    }


}