package com.codeinglogs.moviedetailsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codeinglogs.moviedetails.ui.activity.MovieDetailActivity
import com.codeinglogs.moviedetails.ui.activity.TrandingMoviesActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(MovieDetailActivity.getInstance(this))
    }
}