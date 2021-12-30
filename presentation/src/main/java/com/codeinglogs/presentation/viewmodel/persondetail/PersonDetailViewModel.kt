package com.codeinglogs.presentation.viewmodel.persondetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeinglogs.domain.usecase.getPersonDetail
import com.codeinglogs.presentation.maper.toPresentationState
import com.codeinglogs.presentation.model.Event
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.person.persondetails.PersonDetailsDisplay
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonDetailViewModel @Inject constructor(private val getPersonDetailsUseCase: getPersonDetail): ViewModel() {

    private val _PersonDetails = MutableLiveData<Event<State<PersonDetailsDisplay>>>()
    val personDetails : LiveData<Event<State<PersonDetailsDisplay>>>
        get() = _PersonDetails


    fun getPersonDetails(id: String) {
        viewModelScope.launch {
            getPersonDetailsUseCase(id).collect{
                _PersonDetails.value= Event(it.toPresentationState())

            }
        }
    }
}