package com.codeinglogs.local.dao.maylist.movie

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinglogs.local.entity.mylist.movie.MyMovieList

@Dao
interface MyMovieListDao {

    @Insert
    suspend fun insert(myMovieList: MyMovieList) : Long

    @Update
    suspend fun update(myMovieList: MyMovieList)

    @Delete
    suspend fun delete(myMovieList: MyMovieList)

    @Query("SELECT * FROM MyMovieList")
    fun loadAllMayMovieList() : LiveData<MyMovieList>

    @Insert
    fun insertAllMayMovieList(vararg myMovieList: MyMovieList)

    @Query("SELECT * FROM MyMovieList")
    fun getAllMayMovieList() : List<MyMovieList>

//    @Query("SELECT EXISTS(SELECT * FROM LocalMyMovieListData WHERE movieId = :movieId)")
//    fun isMayMovieListIsExist(movieId : Long) : Boolean
}