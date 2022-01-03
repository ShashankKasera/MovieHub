package com.codeinglogs.presentation.model.tvshow.tvshowdetails

import com.codeinglogs.presentation.model.tvshow.tvshowdetails.credits.TvShowCreditsResponse
import com.codeinglogs.presentation.model.tvshow.tvshowdetails.credits.toPresentationTvShowCreditsResponse
import com.codeinglogs.presentation.model.tvshow.tvshowdetails.image.TvShowImageResponse
import com.codeinglogs.presentation.model.tvshow.tvshowdetails.image.toPresentationTvShowImageResponse
import com.codeinglogs.presentation.model.tvshow.tvshowdetails.info.TvShowInfoResponse
import com.codeinglogs.presentation.model.tvshow.tvshowdetails.info.toPresentationTvShowInfoResponse
import com.codeinglogs.presentation.model.tvshow.tvshowdetails.reviews.TvShowReviewsResponse
import com.codeinglogs.presentation.model.tvshow.tvshowdetails.reviews.toPresentationTvShowReviewsResponse
import com.codeinglogs.presentation.model.tvshow.tvshowdetails.similar.TvShowSimilarResponse
import com.codeinglogs.presentation.model.tvshow.tvshowdetails.similar.toPresentationTvShowSimilarResponse
import com.codeinglogs.presentation.model.tvshow.tvshowdetails.video.TvShowsVideosResponse
import com.codeinglogs.presentation.model.tvshow.tvshowdetails.video.toPresentationTvShowsVideosResponse
import com.codeinglogs.domain.model.tvshow.tvshowdetails.TvShowDetailsDisplay as DomainTvShowDetailsDisplay


data class TvShowDetailsDisplay(
    val tvShowCreditsResponse: TvShowCreditsResponse,
    val tvShowIMagesResponse: TvShowImageResponse,
    val tvShowInfoResponse: TvShowInfoResponse,
    val tvShowReviewsResponse: TvShowReviewsResponse,
    val tvShowSimilarResponse: TvShowSimilarResponse,
    val tvShowVideosResponse: TvShowsVideosResponse,

    )

fun DomainTvShowDetailsDisplay.toPresentationTvShowDetails()=TvShowDetailsDisplay(
    tvShowCreditsResponse =tvShowCreditsResponse.toPresentationTvShowCreditsResponse(),
    tvShowIMagesResponse =tvShowIMagesResponse.toPresentationTvShowImageResponse(),
    tvShowInfoResponse = tvShowInfoResponse.toPresentationTvShowInfoResponse(),
    tvShowReviewsResponse =tvShowReviewsResponse.toPresentationTvShowReviewsResponse(),
    tvShowSimilarResponse =tvShowSimilarResponse.toPresentationTvShowSimilarResponse(),
    tvShowVideosResponse =tvShowVideosResponse.toPresentationTvShowsVideosResponse()
)