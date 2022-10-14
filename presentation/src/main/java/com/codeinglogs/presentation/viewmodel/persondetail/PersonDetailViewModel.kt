package com.codeinglogs.presentation.viewmodel.persondetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeinglogs.domain.usecase.bookmark.GetBookmarkPersons
import com.codeinglogs.domain.usecase.GetPersonDetail
import com.codeinglogs.presentation.maper.toPresentationState
import com.codeinglogs.presentation.model.Event
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.person.persondetails.PersonDetailsDisplay
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonDetailViewModel @Inject constructor(
    private val getPersonDetailsUseCase: GetPersonDetail,
    private val getBookmarkPersonsUseCase: GetBookmarkPersons
): ViewModel() {

    private val _PersonDetails = MutableLiveData<Event<State<PersonDetailsDisplay>>>()
    val personDetails : LiveData<Event<State<PersonDetailsDisplay>>>
        get() = _PersonDetails

    private val _BookmarkPersons = MutableLiveData<Event<State<Boolean>>>()
    val bookmarkPersons : LiveData<Event<State<Boolean>>>
        get() = _BookmarkPersons

    var personId=""

    fun getPersonDetails(id: String) {
        viewModelScope.launch {
            getPersonDetailsUseCase(id).collect{
                _PersonDetails.value= Event(it.toPresentationState())

            }
        }
    }

    fun getBookmarkPerson(id:Long){
        viewModelScope.launch {
            getBookmarkPersonsUseCase(id).collect {
                _BookmarkPersons.value=Event(it.toPresentationState())
            }
        }
    }
}