package com.codeinglogs.tvshowdetailapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codeinglogs.tvshowdetail.ui.activity.TvShowDetailsActivity
import com.codeinglogs.tvshowdetail.ui.activity.TvShowPagingActivity
import com.codeinglogs.tvshowdetail.ui.activity.TvShowSeasonDetailsActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //startActivity(TvShowDetailsActivity.getInstance(this,"88329"))
        //startActivity(TvShowSeasonDetailsActivity.getInstance(this,"88329",1))
    }
}