package com.codeinglogs.presentation.model.moviedetail.info
import com.codeinglogs.domain.model.moviedetail.info.ProductionCompanies as DomainProductionCompanies

data class ProductionCompanies (
    val name: String?
)

fun DomainProductionCompanies.toProductionCompanies()=ProductionCompanies(
    name=name
)