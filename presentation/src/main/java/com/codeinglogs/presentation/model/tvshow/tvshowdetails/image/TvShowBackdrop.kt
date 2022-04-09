package com.codeinglogs.presentation.model.tvshow.tvshowdetails.image

import com.codeinglogs.domain.model.tvshow.tvshowdetails.image.TvShowBackdrop as DomainTvShowBackdrop

data class TvShowBackdrop(
    val file_path: String,
    val vote_count:Int
)


fun DomainTvShowBackdrop.toPresentationTvShowBackdrop()=TvShowBackdrop(
    file_path = file_path,
    vote_count=vote_count
)