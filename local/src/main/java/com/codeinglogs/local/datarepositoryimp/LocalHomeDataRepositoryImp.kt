package com.codeinglogs.local.datarepositoryimp

import com.codeinglogs.data.model.home.HomeDisplay
import com.codeinglogs.data.model.movies.movieslist.MoviesListResponce
import com.codeinglogs.data.model.person.personlist.PersonListResponce
import com.codeinglogs.data.model.tvshow.tvshowlist.TvShowsListResponce
import com.codeinglogs.data.repository.home.LocalHomeData
import com.codeinglogs.local.dao.*
import com.codeinglogs.local.entity.*
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocalHomeDataRepositoryImp
    @Inject constructor (
        private val personsDao: PersonsDao,
        private val trendingPersonsDao: TrendingPersonsDao,
        private val moviesDao: MoviesDao,
        private val popularMoviesDao: PopularMoviesDao,
        private val topRatedMoviesDao: TopRatedMoviesDao,
        private val trendingMoviesDao: TrendingMoviesDao,
        private val tvShowsDao: TvShowsDao,
        private val popularTvShowsDao: PopularTvShowsDao,
        private val topRatedTvShowsDao: TopRatedTvShowsDao,
        private val trendingTvShowsDao: TrendingTvShowsDao
        ): LocalHomeData {
    override suspend fun getHomeDisplay(): HomeDisplay {
        val data = coroutineScope {
            val trendingPerson = async { trendingPersonsDao.getAllTrendingPersons() }
            val trendingMovie = async { trendingMoviesDao.getAllTrendingMovie() }
            val poPuLarMovie = async { popularMoviesDao.getAllPopularMovies() }
            val topRatedMovie = async { topRatedMoviesDao.getAllTopRatedMovies() }
            val trendingTvShow = async { trendingTvShowsDao.getAllTrendingTvShows() }
            val poPuLarTvShow = async { popularTvShowsDao.getAllPopularTvShows() }
            val topRatedTvShow = async { topRatedTvShowsDao.getAllTopRatedTvShows() }

            HomeDisplay(
                PersonListResponce(results = trendingPerson.await().toDataPersons()),
                MoviesListResponce(results = trendingMovie.await().toDataMovies()),
                MoviesListResponce(results = poPuLarMovie.await().toDataMovies()),
                MoviesListResponce(results = topRatedMovie.await().toDataMovies()),
                TvShowsListResponce(results = trendingTvShow.await().toDataTvShowList()),
                TvShowsListResponce(results = poPuLarTvShow.await().toDataTvShowList()),
                TvShowsListResponce(results = topRatedTvShow.await().toDataTvShowList()),
            )


        }
        return data
    }

    override suspend fun insertHomeDisplay(
        homeDisplay : HomeDisplay
    ) {

        coroutineScope {
            launch { personsDao.insertAllPersons(*homeDisplay.trendingPerson.results.toLocalPersons().toTypedArray()) }
            launch { moviesDao.insertAllMovies(*homeDisplay.trendingMovie.results?.toLocalMovies()?.toTypedArray()?: arrayOf()) }
            launch { moviesDao.insertAllMovies(*homeDisplay.topRatedMovie.results?.toLocalMovies()?.toTypedArray()?: arrayOf()) }
            launch { moviesDao.insertAllMovies(*homeDisplay.popularMovie.results?.toLocalMovies()?.toTypedArray()?: arrayOf()) }
            launch { tvShowsDao.insertAllTvShows(*homeDisplay.trendingTvShow.results.toLocalTvShows().toTypedArray()) }
            launch { tvShowsDao.insertAllTvShows(*homeDisplay.popularTvShow.results.toLocalTvShows().toTypedArray()) }
            launch { tvShowsDao.insertAllTvShows(*homeDisplay.topRatedTvShow.results.toLocalTvShows().toTypedArray()) }
        }
        coroutineScope {
            launch { trendingPersonsDao.insertAllTrendingPersons(*homeDisplay.trendingPerson.results.toLocalTrendingPersonsList().toTypedArray()) }

            launch { popularMoviesDao.insertAllPopularMovies(*homeDisplay.popularMovie.results?.toLocalPopularMoviesList()?.toTypedArray()?: arrayOf()) }
            launch { topRatedMoviesDao.insertAllTopRatedMovies(*homeDisplay.topRatedMovie.results?.toLocalTopRatedMoviesList()?.toTypedArray()?: arrayOf()) }
            launch { trendingMoviesDao.insertAllTrendingMovies(*homeDisplay.trendingMovie.results?.toLocalTrendingMoviesList()?.toTypedArray()?: arrayOf()) }

            launch { popularTvShowsDao.insertAllPopularTvShows(*homeDisplay.popularTvShow.results.toLocalPopularTvShowsList().toTypedArray()) }
            launch { topRatedTvShowsDao.insertAllTopRatedTvShows(*homeDisplay.topRatedTvShow.results.toLocalTopRatedTvShowsList().toTypedArray()) }
            launch { trendingTvShowsDao.insertAllTrendingTvShows(*homeDisplay.trendingTvShow.results.toLocalTrendingTvShowsList().toTypedArray()) }
        }
    }
}