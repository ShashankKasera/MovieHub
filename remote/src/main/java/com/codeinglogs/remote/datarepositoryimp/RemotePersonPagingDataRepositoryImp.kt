package com.codeinglogs.remote.datarepositoryimp

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.codeinglogs.data.model.person.personlist.Person
import com.codeinglogs.data.repository.pagingPerson.RemotePersonPagingData
import com.codeinglogs.remote.pagingsource.PopularPersonPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemotePersonPagingDataRepositoryImp @Inject constructor (
    private val popularPersonPagingSource: PopularPersonPagingSource
) : RemotePersonPagingData {


    override fun getPagingPopularPersons(): Flow<PagingData<Person>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                popularPersonPagingSource }
        ).flow
    }



}