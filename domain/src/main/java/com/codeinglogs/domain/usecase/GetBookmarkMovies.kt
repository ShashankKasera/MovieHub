package com.codeinglogs.domain.usecase

import com.codeinglogs.domain.repository.BookmarkMoviesRepositoryDomain
import javax.inject.Inject

data class GetBookmarkMovies @Inject constructor(private val bookmarkMoviesRepositoryDomain: BookmarkMoviesRepositoryDomain) {
    operator fun invoke(id:Long) = bookmarkMoviesRepositoryDomain.getBookmarkMovies(id)
}