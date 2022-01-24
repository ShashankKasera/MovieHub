package com.codeinglogs.remote.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.codeinglogs.data.model.person.personlist.Person
import com.codeinglogs.remote.model.person.personlist.toDataPerson
import com.codeinglogs.remote.request.PersonRequest
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SearchPersonPagingSource @AssistedInject constructor (
    private val personRequest: PersonRequest,
    @Assisted("personSearch")val  personSearch : String
) : PagingSource<Int, Person>() {
    override fun getRefreshKey(state: PagingState<Int, Person>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Person> {
        val position=params.key?:1
        return try {
            val response=personRequest.getPersonSearch(position,personSearch)
            val photo=response.results?.toDataPerson()
            LoadResult.Page(
                data = photo?: listOf(),
                prevKey = if(position==1) null else position-1,
                nextKey = if(photo?.isEmpty() == true) null else position+1
            )
        }catch (exception: IOException){
            LoadResult.Error(exception)
        }catch (exception: HttpException){
            LoadResult.Error(exception)
        }
    }



    @AssistedFactory
    interface SearchPersonPagingSourceFactory{
        fun create(@Assisted("personSearch") personSearch : String) : SearchPersonPagingSource
    }
}