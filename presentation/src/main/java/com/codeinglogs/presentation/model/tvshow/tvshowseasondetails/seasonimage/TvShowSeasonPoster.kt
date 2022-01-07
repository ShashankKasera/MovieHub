package com.codeinglogs.presentation.model.tvshow.tvshowseasondetails.seasonimage
import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasonimage.TvShowSeasonPoster as DomainTvShowSeasonPoster

data class TvShowSeasonPoster(
    val file_path: String,
)

fun DomainTvShowSeasonPoster.toPresentationTvShowSeasonPoster()=TvShowSeasonPoster(
    file_path=file_path
)