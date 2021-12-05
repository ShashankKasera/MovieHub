package com.codeinglogs.core.di

import android.content.Context
import com.codeinglogs.data.repository.trendingmovies.RemoteTrendingMovies
import com.codeinglogs.data.repousercase.trendingmovies.TrendingMoviesRepositoryImp
import com.codeinglogs.data.store.trendingmovies.TrendingMoviesDataSore
import com.codeinglogs.data.store.trendingmovies.TrendingMoviesRemoteDataSore
import com.codeinglogs.domain.repository.TrendingMoviesRepository
import com.codeinglogs.remote.request.TrendingMoviesRequest
import com.codeinglogs.remote.util.nerwork.BASE_URL
import com.codeinglogs.remote.util.nerwork.NetworkInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Singleton
    @Provides
    fun getBaseUrl():String = BASE_URL

    @Provides
    @Singleton
    fun getOkHttp(@ApplicationContext appContext: Context) = OkHttpClient.Builder()
        .addInterceptor(NetworkInterceptor(appContext))
        .build()

    @Singleton
    @Provides
    fun getRetrofit(baseUrl:String,okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder().baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()


    @Singleton
    @Provides
    fun getTrendingMoviesRequest(retrofit: Retrofit): TrendingMoviesRequest =retrofit.create(
        TrendingMoviesRequest::class.java)


    @Singleton
    @Provides
     fun getTrendingMoviesRepository(repo : TrendingMoviesRepositoryImp): TrendingMoviesRepository = repo

     @Singleton
     @Provides
     fun getDataSore(dataSore : TrendingMoviesRemoteDataSore): TrendingMoviesDataSore = dataSore

     @Singleton
     @Provides
     fun getRemoteTrendingMoviesRepositorySore(dataSore : com.codeinglogs.remote.repositoryimp.TrendingMoviesRepositoryImp): RemoteTrendingMovies = dataSore


}