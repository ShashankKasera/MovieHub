package com.codeinglogs.domain.repository

import androidx.paging.PagingData
import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.model.multi.MultiApiResponse
import kotlinx.coroutines.flow.Flow

interface MultiRepositoryDomain {

    fun getMulti() : Flow<State<MultiApiResponse>>
}