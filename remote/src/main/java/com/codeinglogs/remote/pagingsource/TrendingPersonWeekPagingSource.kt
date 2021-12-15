package com.codeinglogs.remote.pagingsource


import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.codeinglogs.data.model.trendingpersonweek.ResultTrendingPersonWeekList
import com.codeinglogs.remote.model.trendingpersonweek.toDataTrendingPersonWeekResultList
import com.codeinglogs.remote.request.TrendingPersonWeekRequest
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class TrendingPersonWeekPagingSource @Inject constructor (private val trendingPersonWeekRequest: TrendingPersonWeekRequest) : PagingSource<Int, ResultTrendingPersonWeekList>() {
    override fun getRefreshKey(state: PagingState<Int, ResultTrendingPersonWeekList>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResultTrendingPersonWeekList> {
        val position=params.key?:1
        return try {
            val response=trendingPersonWeekRequest.getTrendingPersonWeek(position)
            val photo=response.results.toDataTrendingPersonWeekResultList()
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