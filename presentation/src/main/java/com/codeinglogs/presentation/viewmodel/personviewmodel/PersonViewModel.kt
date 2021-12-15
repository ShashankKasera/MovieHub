package com.codeinglogs.presentation.viewmodel.personviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeinglogs.domain.usecase.GetPerson
import com.codeinglogs.domain.usecase.GetTrendingMovies
import com.codeinglogs.presentation.maper.toPresentationState
import com.codeinglogs.presentation.model.Event
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.person.PersonList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonViewModel@Inject constructor(private val getPerson: GetPerson) : ViewModel() {
    private val _personList= MutableLiveData<Event<State<PersonList>>>()
    val personList : LiveData<Event<State<PersonList>>> get() = _personList

    fun getPersonList(){
        viewModelScope.launch {
            getPerson().collect {
                _personList.value = Event(it.toPresentationState() )
            }
        }
    }

}