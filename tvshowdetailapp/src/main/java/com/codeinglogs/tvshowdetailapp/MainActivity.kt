package com.codeinglogs.tvshowdetailapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codeinglogs.tvshowdetail.ui.activity.TvShowDetailsActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(TvShowDetailsActivity.getInstance(this))
    }
}