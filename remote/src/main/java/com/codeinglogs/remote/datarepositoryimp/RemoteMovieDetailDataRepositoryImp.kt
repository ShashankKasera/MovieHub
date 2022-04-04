package com.codeinglogs.remote.datarepositoryimp

import android.util.Log
import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.movies.moviedetail.MovieDetailsDisplay
import com.codeinglogs.data.repository.moviedetails.RemoteMovieDetailData
import com.codeinglogs.remote.model.movies.moviedetail.credits.toDataMovieCreditsResponse
import com.codeinglogs.remote.model.movies.moviedetail.images.toDataMovieIMagesResponse
import com.codeinglogs.remote.model.movies.moviedetail.info.toDataMovieInfoResponse
import com.codeinglogs.remote.model.movies.moviedetail.reviews.toDataMovieReviewsResponse
import com.codeinglogs.remote.model.movies.moviedetail.similar.toDataMovieSimilarResponse
import com.codeinglogs.remote.model.movies.moviedetail.videos.toDataMovieVideosResponse
import com.codeinglogs.remote.request.MoviesRequest
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteMovieDetailDataRepositoryImp@Inject constructor (private val moviesRequest: MoviesRequest) :
    RemoteMovieDetailData {
    override fun getMovieDetail(id:String)= flow <State<MovieDetailsDisplay>>{
        emit(State.loading())
        val data = coroutineScope{

            Log.i("dsjfbckj", "getMovieDetail  movieCredits: me   $id")
            val movieCredits = async { moviesRequest.getMovieCredits(id)}
            Log.i("dsjfbckj", "getMovieDetail  movieCredits: ${movieCredits.await()}")
            val movieImages = async { moviesRequest.getMovieImages(id)}
            Log.i("dsjfbckj", "getMovieDetail  movieImages: ${movieImages.await()}")
            val movieVideos = async { moviesRequest.getMovieVideos(id)}
            Log.i("dsjfbckj", "getMovieDetail  movieVideos: ${movieVideos.await()}")
            val movieReviews = async { moviesRequest.getMovieReviews(id)}
            Log.i("dsjfbckj", "getMovieDetail  movieReviews: ${movieReviews.await()}")
            val movieInfo = async { moviesRequest.getMovieInfo(id)}
            Log.i("dsjfbckj", "getMovieDetail  movieInfo: ${movieInfo.await()}")
            MovieDetailsDisplay(
                movieCredits.await().toDataMovieCreditsResponse(),
                movieImages.await().toDataMovieIMagesResponse(),
                movieInfo.await().toDataMovieInfoResponse(),
                movieReviews.await().toDataMovieReviewsResponse(),
                movieVideos.await().toDataMovieVideosResponse(),
            )
        }
        emit(State.success(data))
    }.catch {

        Log.i("dsjfbckj", "getMovieDetail  failed: ${it.message}")
        emit(State.failed(it.message?:""))
    }
}