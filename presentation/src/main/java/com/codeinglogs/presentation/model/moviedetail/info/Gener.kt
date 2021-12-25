package com.codeinglogs.presentation.model.moviedetail.info

import com.codeinglogs.domain.model.moviedetail.info.Gener as domainGener
data class Gener(
    val id: Int,
    val name: String
)

fun domainGener.toPresentationGener()=Gener(
    id=id,
    name=name
)