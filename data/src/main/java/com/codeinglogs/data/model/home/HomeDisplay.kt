package com.codeinglogs.data.model.home

import com.codeinglogs.data.model.movies.movieslist.MoviesListResponse
import com.codeinglogs.data.model.movies.movieslist.toDomainMoviesListResponse
import com.codeinglogs.data.model.person.personlist.PersonListResponse
import com.codeinglogs.data.model.person.personlist.toDomainPersonListResponse
import com.codeinglogs.data.model.tvshow.tvshowlist.TvShowsListResponse
import com.codeinglogs.data.model.tvshow.tvshowlist.toDomainTvShowsListResponse
import com.codeinglogs.domain.model.home.HomeDisplay as DomainHomeDisplay

data class HomeDisplay(
    val trendingPerson : PersonListResponse,
    val trendingMovie :  MoviesListResponse,
    val popularMovie :   MoviesListResponse,
    val topRatedMovie :  MoviesListResponse,
    val popularTvShow :  TvShowsListResponse,
    val trendingTvShow : TvShowsListResponse,
    val topRatedTvShow : TvShowsListResponse
)

fun HomeDisplay.toDomainHomeDisplay()=DomainHomeDisplay(

    trendingPerson=trendingPerson.toDomainPersonListResponse(),
    trendingMovie=trendingMovie.toDomainMoviesListResponse(),
    trendingTvShow=trendingTvShow.toDomainTvShowsListResponse(),
    popularMovie =popularMovie.toDomainMoviesListResponse(),
    popularTvShow=popularTvShow.toDomainTvShowsListResponse(),
    topRatedMovie=topRatedMovie.toDomainMoviesListResponse(),
    topRatedTvShow=topRatedTvShow.toDomainTvShowsListResponse()
)