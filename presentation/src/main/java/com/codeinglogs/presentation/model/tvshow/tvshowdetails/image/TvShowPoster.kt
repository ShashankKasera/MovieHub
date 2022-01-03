package com.codeinglogs.presentation.model.tvshow.tvshowdetails.image

import com.codeinglogs.domain.model.tvshow.tvshowdetails.image.TvShowPoster as DomainTvShowPoster

data class TvShowPoster(
    val file_path: String,
)

fun DomainTvShowPoster.toPresentationTvShowPoster()=TvShowPoster(
    file_path=file_path
)