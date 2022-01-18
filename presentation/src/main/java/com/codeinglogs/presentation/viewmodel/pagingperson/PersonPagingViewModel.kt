package com.codeinglogs.presentation.viewmodel.pagingperson

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.codeinglogs.domain.usecase.GetPersonPaging
import com.codeinglogs.presentation.model.person.personlist.toPresentationPerson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject
@HiltViewModel
class PersonPagingViewModel @Inject constructor(
    private val getPersonPagingUseCase: GetPersonPaging,
) : ViewModel() {

    var person  = getPersonPagingUseCase().map {
        it.map {
            it.toPresentationPerson()
        }
    }.cachedIn(viewModelScope).asLiveData()


}