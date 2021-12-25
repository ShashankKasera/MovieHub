package com.codeinglogs.remote.model.moviedetail.info

import com.codeinglogs.data.model.moviedetail.info.Gener as DataGener
data class Gener(
    val id: Int?,
    val name: String?
)

fun Gener.toDataGener()=DataGener(
    id = id?:0,
    name=name?:""
)