package com.codeinglogs.domain.model.home

import com.codeinglogs.domain.model.movies.movieslist.MoviesListResponse
import com.codeinglogs.domain.model.person.personlist.PersonListResponse
import com.codeinglogs.domain.model.tvshow.tvshowslist.TvShowsListResponse

data class HomeDisplay(
    val trendingPerson : PersonListResponse,
    val trendingMovie : MoviesListResponse,
    val trendingTvShow : TvShowsListResponse,
    val popularMovie : MoviesListResponse,
    val popularTvShow : TvShowsListResponse,
    val topRatedMovie : MoviesListResponse,
    val topRatedTvShow : TvShowsListResponse
)