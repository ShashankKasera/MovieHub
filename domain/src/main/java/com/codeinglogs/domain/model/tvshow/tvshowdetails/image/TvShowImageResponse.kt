package com.codeinglogs.domain.model.tvshow.tvshowdetails.image

data class TvShowImageResponse(
    val backdrops: List<TvShowBackdrop>,
    val id: Int,
    val posters: List<TvShowPoster>
)