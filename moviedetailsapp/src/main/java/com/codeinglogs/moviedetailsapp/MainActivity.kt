package com.codeinglogs.moviedetailsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codeinglogs.moviedetails.MovieDetailActivity
import com.codeinglogs.moviedetails.TabActivity
import com.codeinglogs.moviedetails.TabActivity.Companion.getInstance

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(MovieDetailActivity.getInstance(this))
    }
}