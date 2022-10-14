package com.codeinglogs.domain.usecase.bookmark

import com.codeinglogs.domain.repository.bookmark.BookmarkTvShowsRepositoryDomain
import javax.inject.Inject

class GetBookmarkTvShows @Inject constructor(private val bookmarkTvShowsRepositoryDomain: BookmarkTvShowsRepositoryDomain) {
    operator fun invoke(id:Long) = bookmarkTvShowsRepositoryDomain.getBookmarkTvShows(id)
}