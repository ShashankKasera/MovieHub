package com.codeinglogs.domain.usecase

import com.codeinglogs.domain.repository.MultiRepositoryDomain
import com.codeinglogs.domain.repository.TrendingMoviesRepositoryDomain
import javax.inject.Inject

class GetMulti@Inject constructor(private val multiRepositoryDomain: MultiRepositoryDomain) {
    operator fun invoke() = multiRepositoryDomain.getMulti()
}