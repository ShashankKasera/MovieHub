package com.codeinglogs.data.model.home

import com.codeinglogs.data.model.movies.movieslist.MoviesListResponce
import com.codeinglogs.data.model.movies.movieslist.toDomainMoviesListResponce
import com.codeinglogs.data.model.person.personlist.PersonListResponce
import com.codeinglogs.data.model.person.personlist.toDomainPersonListResponce
import com.codeinglogs.data.model.tvshow.tvshowlist.TvShowsListResponce
import com.codeinglogs.data.model.tvshow.tvshowlist.toDomainTvShowsListResponce
import com.codeinglogs.domain.model.home.HomeDisplay as DomainHomeDisplay

data class HomeDisplay(
    val trendingPerson : PersonListResponce,
    val trendingMovie :  MoviesListResponce,
    val popularMovie :   MoviesListResponce,
    val topRatedMovie :  MoviesListResponce,
    val popularTvShow :  TvShowsListResponce,
    val trendingTvShow : TvShowsListResponce,
    val topRatedTvShow : TvShowsListResponce
)

fun HomeDisplay.toDomainHomeDisplay()=DomainHomeDisplay(

    trendingPerson=trendingPerson.toDomainPersonListResponce(),
    trendingMovie=trendingMovie.toDomainMoviesListResponce(),
    trendingTvShow=trendingTvShow.toDomainTvShowsListResponce(),
    popularMovie =popularMovie.toDomainMoviesListResponce(),
    popularTvShow=popularTvShow.toDomainTvShowsListResponce(),
    topRatedMovie=topRatedMovie.toDomainMoviesListResponce(),
    topRatedTvShow=topRatedTvShow.toDomainTvShowsListResponce()
)