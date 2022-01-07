package com.codeinglogs.tvshowdetailapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codeinglogs.tvshowdetail.ui.activity.TvShowDetailsActivity
import com.codeinglogs.tvshowdetail.ui.activity.TvShowSeasonDetailsActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(TvShowSeasonDetailsActivity.getInstance(this))
    }
}