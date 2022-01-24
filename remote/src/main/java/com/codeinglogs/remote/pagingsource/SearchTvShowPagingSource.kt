package com.codeinglogs.remote.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.codeinglogs.data.model.movies.movieslist.Movies
import com.codeinglogs.remote.model.movies.movieslist.toDataMovies
import com.codeinglogs.data.model.tvshow.tvshowlist.TvShow
import com.codeinglogs.remote.model.tvshows.tvshowslist.toDataTvShow
import com.codeinglogs.remote.request.MoviesRequest
import com.codeinglogs.remote.request.TvShowRequest
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SearchTvShowPagingSource @AssistedInject constructor (
    private val tvShowRequest: TvShowRequest,
    @Assisted("tvShowSearch")val  tvShowSearch : String
) : PagingSource<Int, TvShow>() {
    override fun getRefreshKey(state: PagingState<Int, TvShow>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TvShow> {
        val position=params.key?:1
        return try {
            val response=tvShowRequest.getTvShowSearch(position,tvShowSearch)
            val photo=response.results?.toDataTvShow()
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

    @AssistedFactory
    interface SearchTvShowPagingSourceFactory{
        fun create(@Assisted("tvShowSearch") tvShowSearch : String) : SearchTvShowPagingSource
    }


}