package com.codeinglogs.data.domainrepositoryimp

import androidx.paging.map
import com.codeinglogs.data.maper.toDomainState
import com.codeinglogs.data.model.movies.movieslist.toDomainMovies
import com.codeinglogs.data.store.trendingmovies.TrendingMoviesDataSore
import com.codeinglogs.domain.repository.TrendingMoviesRepositoryDomain
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class TrendingMoviesRepositoryDomainImp @Inject constructor (private val trendingMoviesDataSore : TrendingMoviesDataSore) : TrendingMoviesRepositoryDomain {

    override fun getTrendingMovies()=
        trendingMoviesDataSore.getRemoteDataSource()
            .getTrendingMovies().map { it.toDomainState() }

    override fun getPagingTrendingMovies()=
        trendingMoviesDataSore.getRemoteDataSource()
            .getPagingTrendingMovies().map { it->it.map { it.toDomainMovies() } }

}