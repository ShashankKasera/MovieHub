package com.codeinglogs.remote.datarepositoryimp

import android.util.Log
import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.trendingtvshow.TrendingTvShowList
import com.codeinglogs.data.model.trendingtvshow.toDomainTrendingTvShowList
import com.codeinglogs.data.repository.trendingmovies.RemoteTrendingMoviesData
import com.codeinglogs.data.repository.trendingtvshow.RemoteTrendingTvShowData
import com.codeinglogs.remote.model.trendingtvshow.dataTrendingMoviesList
import com.codeinglogs.remote.request.TrendingTvShowRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

private const val TAG = "123MainActivity"
class TrendingTvShowDataRepositoryImp @Inject constructor (private val trendingTvShowRequest: TrendingTvShowRequest) :
    RemoteTrendingTvShowData {
    override fun getTrendingTvShow(): Flow<State<TrendingTvShowList>> = flow <State<TrendingTvShowList>>{
        emit(State.loading())
        val trendingTvShow = trendingTvShowRequest.getTrendingTvShow()
        Log.i(TAG, "repo: ${trendingTvShow}")
        emit(State.success(trendingTvShow.dataTrendingMoviesList()))
    }.catch {
        emit(State.failed(it.message?:""))
    }

}