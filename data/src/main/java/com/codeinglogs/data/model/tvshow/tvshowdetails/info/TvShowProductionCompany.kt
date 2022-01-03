package com.codeinglogs.data.model.tvshow.tvshowdetails.info

import com.codeinglogs.domain.model.tvshow.tvshowdetails.info.TvShowProductionCompany as DomainTvShowProductionCompany

data class TvShowProductionCompany(
    val id: Int,
    val name: String,
)

fun TvShowProductionCompany.toDomainTvShowProductionCompany()=DomainTvShowProductionCompany(
    id=id,
    name=name
)