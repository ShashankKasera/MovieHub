package com.mayank.navigation.route

import com.codeinglogs.moviedetails.ui.route.PersonRoute
import com.mayank.navigation.PersonRouteImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object PersonRouteModule {

    @Singleton
    @Provides
    fun getPersonRoute(personRoute : PersonRouteImp): PersonRoute = personRoute

}