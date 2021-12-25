package com.codeinglogs.data.repository.home


import com.codeinglogs.data.model.home.HomeDisplay

interface LocalHomeData {
    suspend fun getHomeDisplay() : HomeDisplay
    suspend fun insertHomeDisplay(home : HomeDisplay)
}