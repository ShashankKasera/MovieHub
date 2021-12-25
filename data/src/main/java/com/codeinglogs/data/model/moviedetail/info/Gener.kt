package com.codeinglogs.data.model.moviedetail.info

import com.codeinglogs.domain.model.moviedetail.info.Gener as DomainGener
data class Gener(
    val id: Int,
    val name: String
)

fun Gener.toDomainGener()=DomainGener(
    id=id,
    name=name
)