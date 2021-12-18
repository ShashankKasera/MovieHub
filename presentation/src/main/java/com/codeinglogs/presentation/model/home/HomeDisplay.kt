package com.codeinglogs.presentation.model.home


import com.codeinglogs.presentation.model.movies.movieslist.MoviesListResponce
import com.codeinglogs.presentation.model.movies.movieslist.toPresentationMoviesListResponce
import com.codeinglogs.presentation.model.person.personlist.PersonListResponce
import com.codeinglogs.presentation.model.person.personlist.toPresentationPersonListResponce
import com.codeinglogs.presentation.model.tvshow.tvshowslist.TvShowsListResponce
import com.codeinglogs.presentation.model.tvshow.tvshowslist.toPresentationTvShowsListResponce
import com.codeinglogs.domain.model.home.HomeDisplay as domainHomeDisplay

data class HomeDisplay(
    val trendingPerson : PersonListResponce,
    val trendingMovie : MoviesListResponce,
    val trendingTvShow : TvShowsListResponce,
    val popularMovie : MoviesListResponce,
    val popularTvShow : TvShowsListResponce,
    val topRatedMovie : MoviesListResponce,
    val topRatedTvShow : TvShowsListResponce
)

fun domainHomeDisplay.toPresentationHomeDisplay()=HomeDisplay(
    trendingPerson=trendingPerson.toPresentationPersonListResponce(),
    trendingMovie=trendingMovie.toPresentationMoviesListResponce(),
    trendingTvShow=trendingTvShow.toPresentationTvShowsListResponce(),
    popularMovie =popularMovie.toPresentationMoviesListResponce(),
    popularTvShow=popularTvShow.toPresentationTvShowsListResponce(),
    topRatedMovie=topRatedMovie.toPresentationMoviesListResponce(),
    topRatedTvShow=topRatedTvShow.toPresentationTvShowsListResponce(),
)