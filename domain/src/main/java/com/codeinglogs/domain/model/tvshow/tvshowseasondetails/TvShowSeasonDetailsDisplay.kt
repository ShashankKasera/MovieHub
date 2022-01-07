package com.codeinglogs.domain.model.tvshow.tvshowseasondetails

import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasoncredits.TvShowSeasonsCreditsResponse
import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasonimage.TvShowSeasonImageResponse
import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasons.TvShowSeasonsResponse
import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasonvideo.TvShowsSeasonVideosResponse

data class TvShowSeasonDetailsDisplay(
    val tvShowSeasonsCreditsResponse: TvShowSeasonsCreditsResponse,
    val tvShowSeasonsResponse: TvShowSeasonsResponse,
    val tvShowSeasonImageResponse: TvShowSeasonImageResponse,
    val tvShowsSeasonVideosResponse: TvShowsSeasonVideosResponse,
)