package com.codeinglogs.data.domainrepositoryimp

import com.codeinglogs.data.store.bookmark.BookmarkMoviesDataSore
import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.repository.BookmarkMoviesRepositoryDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

import javax.inject.Inject

class BookmarkMoviesRepositoryDomainImp @Inject constructor ( private val bookmarkMoviesDataSore : BookmarkMoviesDataSore) :
    BookmarkMoviesRepositoryDomain {

    override fun getBookmarkMovies(id: Long) = flow {
        emit(State.loading())
        bookmarkMoviesDataSore.getLocalDataSource().insertBookmarkMovies(id)
        emit(State.Success(true))
    }.catch {
        emit(State.failed(it.message?:""))
    }.flowOn(Dispatchers.IO)

}