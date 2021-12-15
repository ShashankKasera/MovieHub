package com.codeinglogs.domain.model.person

data class PersonList(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)