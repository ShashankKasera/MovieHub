package com.codeinglogs.domain.model.tvshow.tvshowdetails

import com.codeinglogs.domain.model.tvshow.tvshowdetails.credits.TvShowCreditsResponse
import com.codeinglogs.domain.model.tvshow.tvshowdetails.image.TvShowImageResponse
import com.codeinglogs.domain.model.tvshow.tvshowdetails.info.TvShowInfoResponse
import com.codeinglogs.domain.model.tvshow.tvshowdetails.reviews.TvShowReviewsResponse
import com.codeinglogs.domain.model.tvshow.tvshowdetails.similar.TvShowSimilarResponse
import com.codeinglogs.domain.model.tvshow.tvshowdetails.video.TvShowsVideosResponse


data class TvShowDetailsDisplay(
    val tvShowCreditsResponse: TvShowCreditsResponse,
    val tvShowIMagesResponse: TvShowImageResponse,
    val tvShowInfoResponse: TvShowInfoResponse,
    val tvShowReviewsResponse: TvShowReviewsResponse,
    val tvShowSimilarResponse: TvShowSimilarResponse,
    val tvShowVideosResponse: TvShowsVideosResponse,

    )