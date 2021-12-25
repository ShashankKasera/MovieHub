package com.codeinglogs.data.repository.trendingtvshow

import com.codeinglogs.data.model.tvshow.tvshowlist.TvShow

interface LocalTrendingTvShowData {
    fun getTrendingTvShow() : TvShow
}