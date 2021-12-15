package com.codeinglogs.remote.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.codeinglogs.data.model.trendingmovies.Result
import com.codeinglogs.remote.model.trendingmovies.toDataTrendingMoviesResultList
import com.codeinglogs.remote.model.trendingpersonweek.toDataTrendingPersonWeekResultList
import com.codeinglogs.remote.request.TrendingMoviesRequest
import com.codeinglogs.remote.request.TrendingPersonWeekRequest
import retrofit2.HttpException
import java.io.IOException

import javax.inject.Inject

class TrendingMoviePagingSource @Inject constructor (private val trendingMoviesRequest: TrendingMoviesRequest) : PagingSource<Int, Result>() {
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        val position=params.key?:1
        return try {
            val response=trendingMoviesRequest.getTrendingMovie(position)
            val photo=response.results.toDataTrendingMoviesResultList()
            LoadResult.Page(
                data = photo,
                prevKey = if(position==1) null else position-1,
                nextKey = if(photo.isEmpty()) null else position+1
            )
        }catch (exception: IOException){
            LoadResult.Error(exception)
        }catch (exception: HttpException){
            LoadResult.Error(exception)
        }
    }


}