package com.codeinglogs.remote.model.moviedetail.info
import com.codeinglogs.data.model.moviedetail.info.ProductionCompanies as DataProductionCompanies

data class ProductionCompanies (
    val name: String?
)

fun ProductionCompanies.toProductionCompanies()=DataProductionCompanies(
    name=name?:""
)