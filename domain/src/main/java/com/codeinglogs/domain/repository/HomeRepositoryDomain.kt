package com.codeinglogs.domain.repository

import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.model.home.HomeDisplay
import kotlinx.coroutines.flow.Flow

interface HomeRepositoryDomain {

    fun getHome() : Flow<State<HomeDisplay>>
}