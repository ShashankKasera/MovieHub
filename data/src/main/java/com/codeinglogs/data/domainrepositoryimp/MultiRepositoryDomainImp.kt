package com.codeinglogs.data.domainrepositoryimp

import androidx.paging.PagingData
import androidx.paging.map
import com.codeinglogs.data.maper.toDomainState
import com.codeinglogs.data.model.multi.toDomainMultiApiResponse
import com.codeinglogs.data.model.trendingmovies.toDomainTrendingMoviesResult
import com.codeinglogs.data.store.multi.MultiDataSore
import com.codeinglogs.data.store.person.PersonDataSore
import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.model.multi.MultiApiResponse
import com.codeinglogs.domain.model.person.PersonList
import com.codeinglogs.domain.repository.MultiRepositoryDomain
import com.codeinglogs.domain.repository.PersonRepositoryDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MultiRepositoryDomainImp @Inject constructor (private val multiDataSore : MultiDataSore) :
    MultiRepositoryDomain {


    override fun getMulti()=
        multiDataSore.getRemoteDataSource()
            .getMulti().map { it.toDomainState() }

}