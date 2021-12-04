package com.codeinglogs.moviehub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.codeinglogs.util.MyClass

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        Log.i("jkjnk", "onCreate: ${MyClass.myfun()}")
    }
}