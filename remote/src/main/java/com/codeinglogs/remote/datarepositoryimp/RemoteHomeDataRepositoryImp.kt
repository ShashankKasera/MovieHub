package com.codeinglogs.remote.datarepositoryimp


import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.home.HomeDisplay
import com.codeinglogs.data.repository.home.RemoteHomeData
import com.codeinglogs.remote.model.movies.movieslist.toDataMoviesListResponse
import com.codeinglogs.remote.model.person.personlist.toDataPersonListResponse
import com.codeinglogs.remote.model.tvshows.tvshowslist.toDataTvShowsListResponse
import com.codeinglogs.remote.request.MoviesRequest
import com.codeinglogs.remote.request.PersonRequest
import com.codeinglogs.remote.request.TvShowRequest
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteHomeDataRepositoryImp  @Inject constructor (
    private val personRequest: PersonRequest,
    private val moviesRequest: MoviesRequest,
    private val tvShowRequest: TvShowRequest,
) : RemoteHomeData {
    override fun getHome(): Flow<State<HomeDisplay>> = flow <State<HomeDisplay>>{
        emit(State.loading())
        val data = coroutineScope {
            val trendingPerson = async { personRequest.getPerson() }
            val trendingMovie = async { moviesRequest.getTrendingMovie() }
            val poPuLarMovie = async { moviesRequest.getPoPuLarMovie() }
            val topRatedMovie = async { moviesRequest.getTopRatedMovie() }
            val trendingTvShow = async { tvShowRequest.getTrendingTvShow() }
            val poPuLarTvShow = async { tvShowRequest.getPoPuLarTvShow() }
            val topRatedTvShow = async { tvShowRequest.getTopRatedTvShow() }

            HomeDisplay(
                trendingPerson.await().toDataPersonListResponse(),
                trendingMovie.await().toDataMoviesListResponse(),
                poPuLarMovie.await().toDataMoviesListResponse(),
                topRatedMovie.await().toDataMoviesListResponse(),
                trendingTvShow.await().toDataTvShowsListResponse(),
                poPuLarTvShow.await().toDataTvShowsListResponse(),
                topRatedTvShow.await().toDataTvShowsListResponse()
            )
        }
        emit(State.success(data))
    }.catch {
        emit(State.failed(it.message?:""))
    }
}