package com.codeinglogs.data.model.moviedetail.info
import com.codeinglogs.domain.model.moviedetail.info.ProductionCompanies as DomainProductionCompanies

data class ProductionCompanies (
    val name: String?
)

fun ProductionCompanies.toProductionCompanies()=DomainProductionCompanies(
    name=name
)