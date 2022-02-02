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

            val movieCredits = async { moviesRequest.getMovieCredits(id)}
            val movieImages = async { moviesRequest.getMovieImages(id)}
            val movieVideos = async { moviesRequest.getMovieVideos(id)}
            val movieReviews = async { moviesRequest.getMovieReviews(id)}
            val movieInfo = async { moviesRequest.getMovieInfo(id)}
            Log.i("iin", "getMovieDetail  movieCredits: me   $id")
            Log.i("iin", "getMovieDetail  movieCredits: ${movieCredits.await()}")
            Log.i("iin", "getMovieDetail  movieImages: ${movieImages.await()}")
            Log.i("iin", "getMovieDetail  movieVideos: ${movieVideos.await()}")
            Log.i("iin", "getMovieDetail  movieReviews: ${movieReviews.await()}")
            Log.i("iin", "getMovieDetail  movieInfo: ${movieInfo.await()}")
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

        Log.i("iin", "getMovieDetail  failed: ${it.message}")
        emit(State.failed(it.message?:""))
    }
}