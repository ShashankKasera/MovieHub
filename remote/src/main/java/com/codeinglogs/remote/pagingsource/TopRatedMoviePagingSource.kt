package com.codeinglogs.remote.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.codeinglogs.data.model.movies.movieslist.Movies
import com.codeinglogs.remote.model.movies.movieslist.toDataMovies
import com.codeinglogs.remote.request.MoviesRequest
import retrofit2.HttpException
import java.io.IOException

import javax.inject.Inject

class TopRatedMoviePagingSource @Inject constructor (private val moviesRequest: MoviesRequest) : PagingSource<Int, Movies>() {
    override fun getRefreshKey(state: PagingState<Int, Movies>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movies> {
        val position=params.key?:1
        return try {
            val response=moviesRequest.getTopRatedMovie(position)
            val photo=response.results?.toDataMovies()
            LoadResult.Page(
                data = photo?: listOf(),
                prevKey = if(position==1) null else position-1,
                nextKey = if(photo?.isEmpty() == true) null else position+1
            )
        }catch (exception: IOException){
            LoadResult.Error(exception)
        }catch (exception: HttpException){
            LoadResult.Error(exception)
        }
    }


}