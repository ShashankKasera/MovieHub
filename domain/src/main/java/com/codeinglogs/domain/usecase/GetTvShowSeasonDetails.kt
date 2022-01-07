package com.codeinglogs.domain.usecase

import com.codeinglogs.domain.repository.TvShowSeasonDetailsRepositoryDomain
import javax.inject.Inject

class GetTvShowSeasonDetails@Inject constructor(
    private val tvShowSeasonDetailsRepositoryDomain: TvShowSeasonDetailsRepositoryDomain
) {
    operator fun invoke(id:String,season_number:Int) = tvShowSeasonDetailsRepositoryDomain.getTvShowSeasonDetails(id,season_number)
}