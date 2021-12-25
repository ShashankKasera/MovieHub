package com.codeinglogs.domain.repository
import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.model.moviedetail.MovieDetailsDisplay
import kotlinx.coroutines.flow.Flow
interface MovieDetailRepositoryDomain {

    fun getMovieDetail(id:String): Flow<State<MovieDetailsDisplay>>
}