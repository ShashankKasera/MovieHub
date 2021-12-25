package com.codeinglogs.local.datarepositoryimp

import com.codeinglogs.data.model.person.personlist.Person
import com.codeinglogs.data.model.tvshow.tvshowlist.TvShow
import com.codeinglogs.data.repository.person.LocalPersonData
import com.codeinglogs.data.repository.trendingtvshow.LocalTrendingTvShowData
import com.codeinglogs.local.dao.PersonsDao
import com.codeinglogs.local.dao.TvShowsDao
import javax.inject.Inject

class LocalTvShowsDataRepositoryImp @Inject constructor (private val tvShowsDao: TvShowsDao) :
    LocalTrendingTvShowData {
    override fun getTrendingTvShow(): TvShow {
        TODO("Not yet implemented")
    }


}