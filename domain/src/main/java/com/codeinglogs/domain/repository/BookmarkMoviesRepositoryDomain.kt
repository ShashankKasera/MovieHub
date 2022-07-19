package com.codeinglogs.domain.repository

import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.model.home.HomeDisplay
import kotlinx.coroutines.flow.Flow

interface BookmarkMoviesRepositoryDomain {
    fun getBookmarkMovies(id:Long) : Flow<State<Boolean>>
}