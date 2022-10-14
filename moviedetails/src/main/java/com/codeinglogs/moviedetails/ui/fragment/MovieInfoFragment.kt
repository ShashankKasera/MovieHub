package com.codeinglogs.moviedetails.ui.fragment

import android.app.AlertDialog
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.core.extension.load
import com.codeinglogs.core.extension.showToast
import com.codeinglogs.moviedetails.R
import com.codeinglogs.moviedetails.databinding.FragmentMovieInfosBinding
import com.codeinglogs.moviedetails.ui.activity.MovieCrewActivity
import com.codeinglogs.moviedetails.ui.adapter.DialogAdapter
import com.codeinglogs.moviedetails.ui.adapter.MovieCrewAdapter
import com.codeinglogs.moviedetails.ui.adapter.MovieGenresAdapter
import com.codeinglogs.moviedetails.ui.adapter.MovieVideoAdapter
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_500
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.movies.moviedetail.MovieDetailsDisplay
import com.codeinglogs.presentation.viewmodel.moviedetail.MovieDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


private const val TAG = "123InfoFragment"
@AndroidEntryPoint
class MovieInfoFragment : BaseFragment<MovieDetailViewModel, FragmentMovieInfosBinding>(){

    private lateinit var movieGenresAdapter: MovieGenresAdapter
    private lateinit var movieVideoAdapter: MovieVideoAdapter
    private lateinit var movieCrewAdapter: MovieCrewAdapter
    private lateinit var movieAddAdapter: DialogAdapter
    private lateinit var addDialogView: View
    private lateinit var addBuilder: AlertDialog

    private var checkForBookmark =false

    override val mViewModel: MovieDetailViewModel by activityViewModels()
    override fun getViewBinding() = FragmentMovieInfosBinding.inflate(layoutInflater)


    override fun onBinding() {
        init()
        movieInfoObserve()
        onclick()
    }

    private fun onclick() {
        mViewBinding.imaBookmarkMovieInfo.setOnClickListener {
            mViewModel.updateBookmarkMovies(mViewModel.movieId.toLong())
            checkForBookmark=true
            setBookmarkImage()
        }
        mViewBinding.imaAddMovieInfo.setOnClickListener {




            //val addDialogView = CustomMovieDialogBinding.inflate(LayoutInflater.from(requireContext()),mViewBinding.root as ViewGroup, false)

            //addBuilder.setContentView(addDialogView.root)

            val addBT=addDialogView.findViewById<AppCompatImageView>(R.id.iv_add)
            val cancelBT=addDialogView.findViewById<Button>(R.id.bt_cancel)

            addBT.setOnClickListener {
                addBuilder.dismiss()

                val createNewListDialogView= View.inflate(context,R.layout.add_new_list_dialog,null)
                val createNewListBuilder= AlertDialog.Builder(context).setView(createNewListDialogView).create()

                val btnCancel=createNewListDialogView.findViewById<Button>(R.id.btn_cancel)
                val btnOk=createNewListDialogView.findViewById<Button>(R.id.btn_ok)
                val etListName=createNewListDialogView.findViewById<EditText>(R.id.et_name_of_list)

                createNewListBuilder.show()

                btnCancel.setOnClickListener {
                    createNewListBuilder.dismiss()
                }
                btnOk.setOnClickListener {


                    createNewListBuilder.dismiss()
                    mViewModel.insertMyMoviesList(mViewModel.movieId,etListName.text.toString())

                    Log.i("gkjnkjnwrgk", "onclick: $etListName.text.toString()")
                    movieAddAdapter.notifyDataSetChanged()
                }





            }
            addBuilder.show()
            cancelBT.setOnClickListener {
                addBuilder.dismiss()
            }
        }
    }

    private fun init() {

        initProgressBar(mViewBinding.movieDetailLoader)
        setUpDialog()
        setUpGenresAdapter()
        setUpCrewAdapter()
        setUpVideoAdapter()
    }

    private fun movieInfoObserve(){
        mViewModel.movieDetails.observe(this){
            it.peekContent()?.let{it ->
                when(it){
                    is State.Failed -> {
                        Log.i(TAG, "Failed: 123InfoFragment ${it.message}")
                        showProgressBar(false)
                        showToast(it.message)
                    }
                    is State.Loading -> {
                        Log.i(TAG, "Loading: 123InfoFragment ")

                        if(it.data!=null&&it.data?.movieCreditsResponse?.crew?.isNotEmpty() == true){
                            setDetails(it.data!!)
                            setCrew(it.data!!)
                            setTrailer(it.data!!)
                            setFact(it.data!!)
                            setMedia(it.data!!)
                            setProductionCompanies(it.data!!)
                            checkForBookmark=it.data!!.Bookmark
                            setBookmarkImage()
                            showProgressBar(false)
                        }
                        else{
                            showProgressBar(true)
                        }
                    }
                    is State.Success -> {
                        Log.i(TAG, "Success: 123InfoFragment ${it.data.Bookmark}")

                        lifecycleScope.launch(Dispatchers.Main) {
                            showProgressBar(false)
                            setDetails(it.data)
                            setCrew(it.data)
                            setTrailer(it.data)
                            setFact(it.data)
                            setMedia(it.data)
                            setMyMovieList(it.data)

                            Log.i("hnek", "movieInfoObserve: ${it.data.myMovieList}")
                            checkForBookmark=it.data.Bookmark
                            setBookmarkImage()
                            setProductionCompanies(it.data)

                            Log.i("nknk", "movieInfoObserve: bookmark ${it.data.Bookmark}")



                            mViewBinding.tvShowAllMovieInfo.setOnClickListener(){
                                startActivity(MovieCrewActivity.getInstance(requireContext(),mViewModel.movieId))
                            }

                        }


                    }
                }
            }
        }
        mViewModel.bookmarkMovies.observe(this){
            it.peekContent()?.let { it ->
                when(it){
                    is State.Failed -> {
                        Log.i(TAG, "Failed: 123InfoFragment ${it.message}")
                        showProgressBar(false)
                        showToast(it.message)
                    }
                    is State.Loading -> {

                    }
                    is State.Success -> {

                        Log.i("hkkbk", "movieInfoObserve: ")
                    }
                }
            }
        }
        mViewModel.myMoviesList.observe(this){
            it.peekContent()?.let { it ->
                when(it){
                    is State.Failed -> {
                        Log.i("hkkbk", "Failed: 123InfoFragment ${it.message}")
                        showProgressBar(false)
                        showToast(it.message)
                    }
                    is State.Loading -> {

                    }
                    is State.Success -> {

                        val list = movieAddAdapter.currentList.toMutableList()
                        list.add(it.data)
                        movieAddAdapter.submitList(list)
                        movieAddAdapter.notifyDataSetChanged()

                        Log.i("hkkbk", "movieInfoObserve: ${it.data}")
                    }
                }

            }
        }
        mViewModel.myMoviesListDetails.observe(this){
            it.peekContent()?.let { it ->
                when(it){
                    is State.Failed -> {
                        Log.i(TAG, "Failed: 123InfoFragment ${it.message}")
                        showProgressBar(false)
                        showToast(it.message)
                    }
                    is State.Loading -> {

                    }
                    is State.Success -> {

                        Log.i("hkkbk", "movieInfoObserve: ")
                    }
                }

            }
        }
    }

    private fun setBookmarkImage() {

        if(!checkForBookmark){
            mViewBinding.imaBookmarkMovieInfo.setImageResource(R.drawable.bookmark_border)
        }else{
            mViewBinding.imaBookmarkMovieInfo.setImageResource(R.drawable.bookmark)
        }
    }

    private fun setUpDialog(){
        addDialogView = View.inflate(context,R.layout.custom_movie_dialog,null)
        addBuilder= AlertDialog.Builder(context).setView(addDialogView).create()
        movieAddAdapter = DialogAdapter{ isChecked, myMovieListId ->
            if(isChecked){
                mViewModel.insertMyMoviesListDetails(myMovieListId,mViewModel.movieId.toLong())
            }
        }
        var rv=addDialogView.findViewById<RecyclerView>(R.id.rv_list)
        rv.layoutManager= LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        rv.adapter=this.movieAddAdapter
    }


    private fun setDetails(it: MovieDetailsDisplay){

        mViewBinding.tvTimeMovieInfo.text=convertNumberToHoursMinutes(it.movieInfoResponse.runtime)
        mViewBinding.tvMovieNameMovieInfo.text=it.movieInfoResponse.title
        mViewBinding.tvDescriptionMovieInfo.text=it.movieInfoResponse.overview

        if(it.movieInfoResponse.release_date.length>4)
            mViewBinding.tvYearMovieInfo.text=it.movieInfoResponse.release_date.substring(0,4)
        else
            mViewBinding.tvYearMovieInfo.text=it.movieInfoResponse.release_date

        movieGenresAdapter.submitList(it.movieInfoResponse.genres)
    }

    private fun convertNumberToHoursMinutes(runtime:Int):kotlin.String{
        val hours = runtime / 60
        val mins = (runtime %  60)

        return "$hours Hours: $mins Minutes"
    }

    private fun setUpGenresAdapter() {
        movieGenresAdapter = MovieGenresAdapter()
        mViewBinding.rvMovieTypeMovieInfo.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        mViewBinding.rvMovieTypeMovieInfo.adapter=this.movieGenresAdapter


    }

    private fun setCrew(it: MovieDetailsDisplay) {
        movieCrewAdapter.submitList(it.movieCreditsResponse.crew)
    }

    private fun setMyMovieList(it: MovieDetailsDisplay) {
        Log.i(TAG, "setMyMovieList: ")
        movieAddAdapter.submitList(it.myMovieList)
    }

    private fun setUpCrewAdapter() {
        movieCrewAdapter = MovieCrewAdapter()
        mViewBinding.rvCrewMovieInfo.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        mViewBinding.rvCrewMovieInfo.adapter=this.movieCrewAdapter


    }

    private fun setTrailer(it: MovieDetailsDisplay){
        movieVideoAdapter.submitList(it.MovieVideosResponse.results)
    }

    private fun setUpVideoAdapter() {
        movieVideoAdapter = MovieVideoAdapter()
        mViewBinding.rvVideoMovieInfo.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        mViewBinding.rvVideoMovieInfo.adapter=this.movieVideoAdapter
    }

    private fun setFact(it: MovieDetailsDisplay){
        mViewBinding.tvTitleFactMovieInfo.text=it.movieInfoResponse.title
        mViewBinding.tvStatusFactMovieInfo.text=it.movieInfoResponse.status
        mViewBinding.tvReleaseDateFactMovieInfo.text=it.movieInfoResponse.release_date
        mViewBinding.tvOriginalLanguageFactMovieInfo.text=it.movieInfoResponse.original_language
        mViewBinding.tvRuntimeFactMovieInfo.text=convertNumberToHoursMinutes(it.movieInfoResponse.runtime)
        mViewBinding.tvBudgetFactMovieInfo.text=it.movieInfoResponse.budget.toString()
        mViewBinding.tvRevenueFactMovieInfo.text=it.movieInfoResponse.revenue.toString()
        mViewBinding.tvRevenueFactMovieInfo.text=it.movieInfoResponse.revenue.toString()

    }

    private fun setMedia(it: MovieDetailsDisplay){

        if(it.movieIMagesResponse.posters.size>0) {
            mViewBinding.ivPosterMovieInfo.load(IMAGE_BASE_URL_500 + it.movieIMagesResponse.posters.get(0).file_path)
            mViewBinding.tvNumberOfPosterMovieInfo.text = it.movieIMagesResponse.posters.size.toString() + " Posters"
        }
        if(it.movieIMagesResponse.backdrops.size>0) {
            mViewBinding.ivBackdropMovieInfo.load(IMAGE_BASE_URL_500 + it.movieIMagesResponse.backdrops.get(0).file_path)
            mViewBinding.tvNumberOfBackdropMovieInfo.text = it.movieIMagesResponse.backdrops.size.toString() + " Backdrops"
        }
    }

    private fun setProductionCompanies(it: MovieDetailsDisplay){
        var production_companies=""
        for (i in 1..(it.movieInfoResponse.production_companies.size-1 )) {
            production_companies+=it.movieInfoResponse.production_companies.get(i).name+", "
        }
        mViewBinding.tvProductionCompaniesMovieInfo.text=production_companies
    }

}