package com.codeinglogs.presentation.model.tvshow.tvshowdetails.info

import com.codeinglogs.domain.model.tvshow.tvshowdetails.info.TvShowProductionCompany as DomainTvShowProductionCompany

data class TvShowProductionCompany(
    val id: Int,
    val name: String,
)
fun DomainTvShowProductionCompany.toPresentationTvShowProductionCompany()=TvShowProductionCompany(
    id=id,
    name=name
)