package com.codeinglogs.moviedetailsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codeinglogs.moviedetails.ui.activity.MovieDetailActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //startActivity(MovieDetailActivity.getInstance(this,"634649"))
    }
}