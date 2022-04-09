package com.codeinglogs.remote.datarepositoryimp

import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.tvshow.tvshowdetails.TvShowDetailsDisplay
import com.codeinglogs.data.repository.tvshowetails.RemoteTvShowDetailData
import com.codeinglogs.remote.model.tvshows.tvshowdetails.credits.toDataTvShowCreditsResponse
import com.codeinglogs.remote.model.tvshows.tvshowdetails.info.toDataTvShowInfoResponse
import com.codeinglogs.remote.model.tvshows.tvshowdetails.reviews.toDataTvShowReviewsResponse
import com.codeinglogs.remote.model.tvshows.tvshowdetails.similar.toDataTvShowSimilarResponse
import com.codeinglogs.remote.model.tvshows.tvshowdetails.image.toDataTvShowImageResponse
import com.codeinglogs.remote.model.tvshows.tvshowdetails.video.toDataTvShowsVideosResponse
import com.codeinglogs.remote.request.TvShowRequest
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteTvShowDetailDataRepositoryImp@Inject constructor (private val tvShowRequest: TvShowRequest) :
    RemoteTvShowDetailData {
    override fun getTvShowDetail(id:String)= flow <State<TvShowDetailsDisplay>>{
        emit(State.loading())
        val data = coroutineScope{

            val tvShowCredits = async { tvShowRequest.getTvShowCredits(id)}
            val tvShowImages = async { tvShowRequest.getTvShowImages(id)}
            val tvShowVideos = async { tvShowRequest.getTvShowVideos(id)}
            val tvShowReviews = async { tvShowRequest.getTvShowReviews(id)}
            val tvShowInfo = async { tvShowRequest.getTvShowInfo(id)}

            TvShowDetailsDisplay(

                tvShowCredits.await().toDataTvShowCreditsResponse(),
                tvShowImages.await().toDataTvShowImageResponse(),
                tvShowInfo.await().toDataTvShowInfoResponse(),
                tvShowReviews.await().toDataTvShowReviewsResponse(),
                tvShowVideos.await().toDataTvShowsVideosResponse()

            )
        }
        emit(State.success(data))
    }.catch {
        emit(State.failed(it.message?:""))
    }
}