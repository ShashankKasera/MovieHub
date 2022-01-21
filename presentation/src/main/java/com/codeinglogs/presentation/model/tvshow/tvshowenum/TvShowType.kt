package com.codeinglogs.presentation.model.tvshow.tvshowenum
import com.codeinglogs.domain.model.tvshow.tvshowenum.TvShowType as DomainTvShowType

enum class TvShowType {
    TRENDING,POPULAR,TOP_RATED,SIMILAR
}

fun TvShowType.toDomainTvShowType()= when(this){
    TvShowType.TRENDING -> DomainTvShowType.TRENDING
    TvShowType.POPULAR -> DomainTvShowType.POPULAR
    TvShowType.TOP_RATED -> DomainTvShowType.TOP_RATED
    TvShowType.SIMILAR -> DomainTvShowType.SIMILAR
}