package com.codeinglogs.data.domainrepositoryimp
import androidx.paging.map
import com.codeinglogs.data.model.person.personlist.toDomainPerson
import com.codeinglogs.data.store.pagingperson.PersonPagingDataSore
import com.codeinglogs.domain.model.person.personenum.PersonType
import com.codeinglogs.domain.repository.PersonPagingRepositoryDomain
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PersonPagingRepositoryDomainImp  @Inject constructor (
    private val moviesPagingDataSore : PersonPagingDataSore
) : PersonPagingRepositoryDomain {
    override fun getPagingPerson(personType: PersonType, personSearch: String) =

        when(personType) {

            PersonType.SEARCH ->{
                moviesPagingDataSore.getRemoteDataSource().getPagingSearchPersons(personSearch).map {
                    it->it.map { it.toDomainPerson() }
                }
            }
            PersonType.POPULAR ->{
                moviesPagingDataSore.getRemoteDataSource().getPagingPopularPersons().map {
                        it->it.map { it.toDomainPerson() }
                }
            }
        }



}