package com.codeinglogs.remote.datarepositoryimp

import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.moviedetail.MovieDetailsDisplay
import com.codeinglogs.data.repository.moviedetails.RemoteMovieDetailData
import com.codeinglogs.remote.model.moviedetail.credits.toDataMovieCreditsResponse
import com.codeinglogs.remote.model.moviedetail.images.toDataMovieIMagesResponse
import com.codeinglogs.remote.model.moviedetail.info.toDataMovieInfoResponse
import com.codeinglogs.remote.model.moviedetail.reviews.toDataMovieReviewsResponse
import com.codeinglogs.remote.model.moviedetail.similar.toDataMovieSimilarResponse
import com.codeinglogs.remote.model.moviedetail.videos.toDataMovieVideosResponse
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
            val movieSimilar = async { moviesRequest.getMovieSimilar(id)}
            val movieReviews = async { moviesRequest.getMovieReviews(id)}
            val movieInfo = async { moviesRequest.getMovieInfo(id)}

            MovieDetailsDisplay(

                movieCredits.await().toDataMovieCreditsResponse(),
                movieImages.await().toDataMovieIMagesResponse(),
                movieInfo.await().toDataMovieInfoResponse(),
                movieReviews.await().toDataMovieReviewsResponse(),
                movieSimilar.await().toDataMovieSimilarResponse(),
                movieVideos.await().toDataMovieVideosResponse(),

            )
        }
        emit(State.success(data))
    }.catch {
        emit(State.failed(it.message?:""))
    }
}