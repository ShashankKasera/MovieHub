package com.codeinglogs.data.domainrepositoryimp

import com.codeinglogs.data.maper.toDomainState
import com.codeinglogs.data.store.person.PersonDataSore
import com.codeinglogs.data.store.trendingmovies.TrendingMoviesDataSore
import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.model.person.PersonList
import com.codeinglogs.domain.model.trendingmovies.TrendingMoviesList
import com.codeinglogs.domain.repository.PersonRepositoryDomain
import com.codeinglogs.domain.repository.TrendingMoviesRepositoryDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PersonRepositoryDomainImp @Inject constructor (private val PersonDataSore : PersonDataSore) :
    PersonRepositoryDomain {

    override fun getPerson(): Flow<State<PersonList>> {
        return flow {
            PersonDataSore.getRemoteDataSource().getPerson().collect {
                emit(it.toDomainState())
            }
        }
    }

}