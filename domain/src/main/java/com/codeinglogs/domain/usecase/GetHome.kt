package com.codeinglogs.domain.usecase

import com.codeinglogs.domain.repository.HomeRepositoryDomain
import javax.inject.Inject

class GetHome@Inject constructor(private val homeRepositoryDomain: HomeRepositoryDomain) {
    operator fun invoke() = homeRepositoryDomain.getHome()
}