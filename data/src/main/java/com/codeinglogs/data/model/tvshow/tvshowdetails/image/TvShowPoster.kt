package com.codeinglogs.data.model.tvshow.tvshowdetails.image

import com.codeinglogs.domain.model.tvshow.tvshowdetails.image.TvShowPoster as DomainTvShowPoster

data class TvShowPoster(
    val file_path: String,
    val vote_count:Int
)

fun TvShowPoster.toDomainTvShowPoster()=DomainTvShowPoster(
    file_path=file_path,
    vote_count=vote_count
)