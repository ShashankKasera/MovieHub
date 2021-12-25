package com.codeinglogs.data.repository.moviedetails

import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.moviedetail.MovieDetailsDisplay
import kotlinx.coroutines.flow.Flow

interface RemoteMovieDetailData {
    fun getMovieDetail(id:String) : Flow<State<MovieDetailsDisplay>>
}