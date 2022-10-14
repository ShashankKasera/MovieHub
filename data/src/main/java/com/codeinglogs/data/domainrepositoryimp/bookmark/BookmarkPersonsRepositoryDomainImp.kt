package com.codeinglogs.data.domainrepositoryimp.bookmark

import com.codeinglogs.data.store.bookmark.bookmarkpersons.BookmarkPersonsDataSore
import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.repository.bookmark.BookmarkPersonsRepositoryDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class BookmarkPersonsRepositoryDomainImp @Inject constructor (private val bookmarkPersonsDataSore : BookmarkPersonsDataSore) :
    BookmarkPersonsRepositoryDomain {

    override fun getBookmarkPersons(id: Long) = flow {
        emit(State.loading())
        bookmarkPersonsDataSore.getLocalDataSource().insertBookmarkPerson(id)
        emit(State.Success(true))
    }.catch {
        emit(State.failed(it.message?:""))
    }.flowOn(Dispatchers.IO)

}