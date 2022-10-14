package com.codeinglogs.data.repository.bookmark

interface LocalBookmarkPersonsData {
    suspend fun insertBookmarkPerson(Bookmark: Long)
}