package com.codeinglogs.domain.usecase.bookmark

import com.codeinglogs.domain.repository.bookmark.BookmarkPersonsRepositoryDomain
import javax.inject.Inject

data class GetBookmarkPersons@Inject constructor(private val bookmarkPersonsRepositoryDomain: BookmarkPersonsRepositoryDomain) {
    operator fun invoke(id:Long) = bookmarkPersonsRepositoryDomain.getBookmarkPersons(id)
}