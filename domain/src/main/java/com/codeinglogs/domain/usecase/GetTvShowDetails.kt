package com.codeinglogs.domain.usecase

import com.codeinglogs.domain.repository.TvShowDetailRepositoryDomain
import javax.inject.Inject

class GetTvShowDetails @Inject constructor(private val tvShowDetailRepositoryDomain: TvShowDetailRepositoryDomain) {

    operator fun invoke(id:String) = tvShowDetailRepositoryDomain.getTvShowDetail(id)
}