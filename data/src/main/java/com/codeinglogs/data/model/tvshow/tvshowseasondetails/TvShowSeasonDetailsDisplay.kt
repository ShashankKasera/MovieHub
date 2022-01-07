package com.codeinglogs.data.model.tvshow.tvshowseasondetails

import com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasoncredits.TvShowSeasonsCreditsResponse
import com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasoncredits.toDomainTvShowSeasonsCreditsResponse
import com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasonimage.TvShowSeasonImageResponse
import com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasonimage.toDomainTvShowSeasonImageResponse
import com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasons.TvShowSeasonsResponse
import com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasons.toDomainTvShowSeasonsResponse
import com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasonvideo.TvShowsSeasonVideosResponse
import com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasonvideo.toDomainTvShowsSeasonVideosResponse
import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.TvShowSeasonDetailsDisplay as DomainTvShowSeasonDetailsDisplay

data class TvShowSeasonDetailsDisplay(
    val tvShowSeasonsCreditsResponse: TvShowSeasonsCreditsResponse,
    val tvShowSeasonsResponse: TvShowSeasonsResponse,
    val tvShowSeasonImageResponse: TvShowSeasonImageResponse,
    val tvShowsSeasonVideosResponse: TvShowsSeasonVideosResponse,
)

fun TvShowSeasonDetailsDisplay.toDomainTvShowSeasonDetailsDisplay()=DomainTvShowSeasonDetailsDisplay(
    tvShowSeasonsCreditsResponse=tvShowSeasonsCreditsResponse.toDomainTvShowSeasonsCreditsResponse(),
    tvShowSeasonsResponse=tvShowSeasonsResponse.toDomainTvShowSeasonsResponse(),
    tvShowSeasonImageResponse=tvShowSeasonImageResponse.toDomainTvShowSeasonImageResponse(),
    tvShowsSeasonVideosResponse=tvShowsSeasonVideosResponse.toDomainTvShowsSeasonVideosResponse()
)