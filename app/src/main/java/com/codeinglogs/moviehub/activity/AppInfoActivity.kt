package com.codeinglogs.moviehub.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codeinglogs.moviehub.R

class AppInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_info)
    }

    companion object{
        fun getInstance(context: Context) = Intent(context, AppInfoActivity::class.java)

    }
}