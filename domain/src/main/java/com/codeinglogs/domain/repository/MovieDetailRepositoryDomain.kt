package com.codeinglogs.domain.repository
import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.model.movies.moviedetail.MovieDetailsDisplay
import com.codeinglogs.domain.model.movies.mylist.MyMovieListDisplay
import kotlinx.coroutines.flow.Flow
interface MovieDetailRepositoryDomain {
    fun getMovieDetail(id:String): Flow<State<MovieDetailsDisplay>>
    fun updateBookmarkMovies(id:Long) : Flow<State<Boolean>>
    fun insertMyMoviesList(name: String,movieId:String) : Flow<State<Boolean>>

}