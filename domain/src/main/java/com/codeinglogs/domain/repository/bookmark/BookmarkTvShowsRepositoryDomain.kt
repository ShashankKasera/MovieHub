package com.codeinglogs.domain.repository.bookmark

import com.codeinglogs.domain.model.State
import kotlinx.coroutines.flow.Flow

interface BookmarkTvShowsRepositoryDomain {

    fun getBookmarkTvShows(id:Long) : Flow<State<Boolean>>
}