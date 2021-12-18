package com.codeinglogs.presentation.viewmodel.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeinglogs.domain.usecase.GetHome
import com.codeinglogs.presentation.maper.toPresentationState
import com.codeinglogs.presentation.model.Event
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.home.HomeDisplay
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getHomeUseCase: GetHome) : ViewModel(){

    private val _HomeDisplay = MutableLiveData<Event<State<HomeDisplay>>>()
    val homeDisplay : LiveData<Event<State<HomeDisplay>>>
        get() = _HomeDisplay

    fun getHome(){
        viewModelScope.launch {
            getHomeUseCase().collect {
                _HomeDisplay.value = Event(it.toPresentationState())
            }
        }
    }
}