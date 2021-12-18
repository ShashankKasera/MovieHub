package com.codeinglogs.domain.model.home

import com.codeinglogs.domain.model.movies.movieslist.MoviesListResponce
import com.codeinglogs.domain.model.person.personlist.PersonListResponce
import com.codeinglogs.domain.model.tvshow.tvshowslist.TvShowsListResponce

data class HomeDisplay(
    val trendingPerson : PersonListResponce,
    val trendingMovie : MoviesListResponce,
    val trendingTvShow : TvShowsListResponce,
    val popularMovie : MoviesListResponce,
    val popularTvShow : TvShowsListResponce,
    val topRatedMovie : MoviesListResponce,
    val topRatedTvShow : TvShowsListResponce
)