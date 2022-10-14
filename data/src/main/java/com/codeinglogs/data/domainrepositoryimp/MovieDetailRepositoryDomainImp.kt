package com.codeinglogs.data.domainrepositoryimp

import android.util.Log
import com.codeinglogs.data.model.movies.moviedetail.toDomainMovieDetailsDisplay
import com.codeinglogs.data.model.movies.mylist.MyMovieListDisplay
import com.codeinglogs.data.store.bookmark.bookmarkmovie.BookmarkMoviesDataSore
import com.codeinglogs.data.store.maylist.mymovielist.MyMoviesListDataSore
import com.codeinglogs.domain.model.movies.moviedetail.MovieDetailsDisplay
import com.codeinglogs.data.store.moviedetails.MovieDetailsDataSore
import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.repository.MovieDetailRepositoryDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import com.codeinglogs.data.model.State as RemoteState

import  com.codeinglogs.domain.model.movies.mylist.MyMovieListDisplay as DomainMyMovieListDisplay
class MovieDetailRepositoryDomainImp @Inject constructor (
    private val movieDetailsDataSore : MovieDetailsDataSore,
    ):
    MovieDetailRepositoryDomain {



    override fun getMovieDetail(id:String)=flow <State<MovieDetailsDisplay>>{

        Log.i("njknjk", "getMovieDetail: ${id}")

        movieDetailsDataSore.getRemoteDataSource().getMovieDetail(id).collect {
            when(it){


                is RemoteState.Failed -> {
                    if(!movieDetailsDataSore.getLocalDataSource().isMovieDetailExist(id)){
                        emit(State.failed(it.message?:"")).toString()
                    }
                }
                is RemoteState.Loading -> {
                    Log.i("sdkjcks", "id: ${id}")
                    Log.i("sdkjcks", "exist: ${movieDetailsDataSore.getLocalDataSource().isMovieDetailExist(id)}")
                    if(movieDetailsDataSore.getLocalDataSource().isMovieDetailExist(id)){
                        val myMoviesList  = movieDetailsDataSore.getLocalDataSource().getMyMoviesList()
                        val displayList= mutableListOf<MyMovieListDisplay>()
                        myMoviesList.forEach {
                            val list=movieDetailsDataSore.getLocalDataSource().getMyMoviesListDetails(it.id,id)
                            displayList.add(
                                MyMovieListDisplay(
                                    it.id,
                                    it.name,
                                    if(list.isNotEmpty()) list.first().id.toLong() else -1,
                                    list.size>0,)
                            )
                        }
                        val movieAllInfo =  movieDetailsDataSore.getLocalDataSource().getMovieDetail(id)
                        movieAllInfo.Bookmark = movieDetailsDataSore.getLocalDataSource().isBookmarkMoviesIsExist(id.toLong())
                        movieAllInfo.myMovieList = displayList


                        Log.i("hetk", "getMovieDetail: ${movieAllInfo}")
                        emit(State.loading(movieAllInfo.toDomainMovieDetailsDisplay()))
                    }
                    else{
                        emit(State.loading())
                    }
                }
                is RemoteState.Success -> {
                    val myMoviesList  = movieDetailsDataSore.getLocalDataSource().getMyMoviesList()
                    val displayList= mutableListOf<MyMovieListDisplay>()
                    myMoviesList.forEach {
                        val list=movieDetailsDataSore.getLocalDataSource().getMyMoviesListDetails(it.id,id)
                        displayList.add(
                            MyMovieListDisplay(
                                it.id,
                                it.name,
                                if(list.isNotEmpty()) list.first().id.toLong() else -1,
                                list.size>0,)
                        )
                    }

                    val movieAllInfo =  it.data
                    movieAllInfo.Bookmark = movieDetailsDataSore.getLocalDataSource().isBookmarkMoviesIsExist(id.toLong())
                    movieAllInfo.myMovieList = displayList

                    movieDetailsDataSore.getLocalDataSource().insertMovieDetail(it.data)
                    emit(State.success(movieAllInfo.toDomainMovieDetailsDisplay()))
                }
            }
        }
    }.catch {
        if(!movieDetailsDataSore.getLocalDataSource().isMovieDetailExist(id)){
            Log.i("jkerkr", "getMovieDetail: ${it.message} ")
            emit(State.failed(it.message?:""))
        }
    }.flowOn(Dispatchers.IO)

    override fun updateBookmarkMovies(id: Long)=flow {
        emit(State.loading())
        Log.i("njgek", "getBookmarkMovies: ${movieDetailsDataSore.getLocalDataSource().isBookmarkMoviesIsExist(id)} ${id}")
        val check:Boolean
        check=movieDetailsDataSore.getLocalDataSource().isBookmarkMoviesIsExist(id)

        if(!check){
            movieDetailsDataSore.getLocalDataSource().updateBookmarkMovies(id)
        }
        emit(State.Success(!check))
    }.catch {
        emit(State.failed(it.message?:""))
    }.flowOn(Dispatchers.IO)

    override fun insertMyMoviesList(name: String,movieId:String)=flow<State<Boolean>> {
        emit(State.loading())
        movieDetailsDataSore.getLocalDataSource().insertMyMoviesList(name,movieId)
        emit(State.Success(true))
    }


}