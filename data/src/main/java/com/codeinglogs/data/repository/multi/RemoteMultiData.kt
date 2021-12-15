package com.codeinglogs.data.repository.multi


import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.multi.MultiApiResponse
import kotlinx.coroutines.flow.Flow

interface RemoteMultiData {
    fun getMulti() : Flow<State<MultiApiResponse>>
}