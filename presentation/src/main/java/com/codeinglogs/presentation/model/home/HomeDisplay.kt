package com.codeinglogs.presentation.model.home


import com.codeinglogs.presentation.model.movies.movieslist.MoviesListResponse
import com.codeinglogs.presentation.model.movies.movieslist.toPresentationMoviesListResponse
import com.codeinglogs.presentation.model.person.personlist.PersonListResponse
import com.codeinglogs.presentation.model.person.personlist.toPresentationPersonListResponse
import com.codeinglogs.presentation.model.tvshow.tvshowslist.TvShowsListResponse
import com.codeinglogs.presentation.model.tvshow.tvshowslist.toPresentationTvShowsListResponse
import com.codeinglogs.domain.model.home.HomeDisplay as domainHomeDisplay

data class HomeDisplay(
    val trendingPerson : PersonListResponse,
    val trendingMovie : MoviesListResponse,
    val trendingTvShow : TvShowsListResponse,
    val popularMovie : MoviesListResponse,
    val popularTvShow : TvShowsListResponse,
    val topRatedMovie : MoviesListResponse,
    val topRatedTvShow : TvShowsListResponse
)

fun domainHomeDisplay.toPresentationHomeDisplay()=HomeDisplay(
    trendingPerson=trendingPerson.toPresentationPersonListResponse(),
    trendingMovie=trendingMovie.toPresentationMoviesListResponse(),
    trendingTvShow=trendingTvShow.toPresentationTvShowsListResponse(),
    popularMovie =popularMovie.toPresentationMoviesListResponse(),
    popularTvShow=popularTvShow.toPresentationTvShowsListResponse(),
    topRatedMovie=topRatedMovie.toPresentationMoviesListResponse(),
    topRatedTvShow=topRatedTvShow.toPresentationTvShowsListResponse(),
)