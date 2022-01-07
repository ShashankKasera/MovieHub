package com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasonimage
import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasonimage.TvShowSeasonPoster as DomainTvShowSeasonPoster

data class TvShowSeasonPoster(
    val file_path: String,
)

fun TvShowSeasonPoster.toDomainTvShowSeasonPoster()=DomainTvShowSeasonPoster(
    file_path=file_path
)