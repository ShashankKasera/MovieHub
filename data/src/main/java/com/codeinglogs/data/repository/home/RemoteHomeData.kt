package com.codeinglogs.data.repository.home


import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.home.HomeDisplay
import kotlinx.coroutines.flow.Flow

interface RemoteHomeData {
    fun getHome() : Flow<State<HomeDisplay>>
}