package com.codeinglogs.data.model.tvshow.tvshowdetails

import com.codeinglogs.data.model.tvshow.tvshowdetails.credits.TvShowCreditsResponse
import com.codeinglogs.data.model.tvshow.tvshowdetails.credits.toDomainTvShowCreditsResponse
import com.codeinglogs.data.model.tvshow.tvshowdetails.info.TvShowInfoResponse
import com.codeinglogs.data.model.tvshow.tvshowdetails.info.toDomainTvShowInfoResponse
import com.codeinglogs.data.model.tvshow.tvshowdetails.reviews.TvShowReviewsResponse
import com.codeinglogs.data.model.tvshow.tvshowdetails.reviews.toDomainTvShowReviewsResponse
import com.codeinglogs.data.model.tvshow.tvshowdetails.similar.TvShowSimilarResponse
import com.codeinglogs.data.model.tvshow.tvshowdetails.similar.toDomainTvShowSimilarResponse
import com.codeinglogs.data.model.tvshow.tvshowdetails.image.TvShowImageResponse
import com.codeinglogs.data.model.tvshow.tvshowdetails.image.toDomainTvShowImageResponse
import com.codeinglogs.data.model.tvshow.tvshowdetails.video.TvShowsVideosResponse
import com.codeinglogs.data.model.tvshow.tvshowdetails.video.toDomainTvShowsVideosResponse
import com.codeinglogs.domain.model.tvshow.tvshowdetails.TvShowDetailsDisplay as DomainTvShowDetailsDisplay


data class TvShowDetailsDisplay(
    val tvShowCreditsResponse: TvShowCreditsResponse,
    val tvShowIMagesResponse: TvShowImageResponse,
    val tvShowInfoResponse: TvShowInfoResponse,
    val tvShowReviewsResponse: TvShowReviewsResponse,
    val tvShowSimilarResponse: TvShowSimilarResponse,
    val tvShowVideosResponse: TvShowsVideosResponse,
    )

fun TvShowDetailsDisplay.toDomainTvShowDetails()=DomainTvShowDetailsDisplay(
    tvShowCreditsResponse =tvShowCreditsResponse.toDomainTvShowCreditsResponse(),
    tvShowIMagesResponse = tvShowIMagesResponse.toDomainTvShowImageResponse(),
    tvShowInfoResponse = tvShowInfoResponse.toDomainTvShowInfoResponse(),
    tvShowReviewsResponse =tvShowReviewsResponse.toDomainTvShowReviewsResponse(),
    tvShowSimilarResponse =tvShowSimilarResponse.toDomainTvShowSimilarResponse(),
    tvShowVideosResponse = tvShowVideosResponse.toDomainTvShowsVideosResponse(),
)