package com.codeinglogs.remote.datarepositoryimp


import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.multi.MultiApiResponse
import com.codeinglogs.data.model.person.PersonList
import com.codeinglogs.data.repository.multi.RemoteMultiData
import com.codeinglogs.remote.model.trendingmovies.toDataTrendingMoviesList
import com.codeinglogs.remote.model.trendingpersonweek.toDataTrendingPersonWeekList
import com.codeinglogs.remote.request.TrendingMoviesRequest
import com.codeinglogs.remote.request.TrendingPersonWeekRequest
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MultiDataRepositoryImp  @Inject constructor (
    private val trendingMoviesRequest: TrendingMoviesRequest,
    private val trendingPersonWeekRequest: TrendingPersonWeekRequest,
) : RemoteMultiData {
    override fun getMulti(): Flow<State<MultiApiResponse>> = flow <State<MultiApiResponse>>{
        emit(State.loading())
        val data = coroutineScope {
            val trendingMovie = async { trendingMoviesRequest.getTrendingMovie() }
            val trendingPerson = async { trendingPersonWeekRequest.getTrendingPersonWeek() }
            MultiApiResponse(
                trendingPerson.await().toDataTrendingPersonWeekList(),
                trendingMovie.await().toDataTrendingMoviesList()
            )
        }
        emit(State.success(data))
    }.catch {
        emit(State.failed(it.message?:""))
    }
}