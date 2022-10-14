package com.codeinglogs.moviedetailsapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.codeinglogs.moviedetails.ui.activity.MovieDetailActivity
import com.codeinglogs.moviedetails.ui.activity.MoviesPagingActivity
import com.codeinglogs.presentation.model.movies.movieenum.MovieType
import java.io.FileNotFoundException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val btn = findViewById<TextView>(R.id.btn)
//        btn.setOnClickListener {
//            //startActivity(MovieDetailActivity.getInstance(this,"524434"))
//            shareToInstagram()
//        }
       startActivity(MoviesPagingActivity.getInstance(this,MovieType.TRENDING))
    }

////    private fun shareToInstagram() {
////
////        val intent = packageManager.getLaunchIntentForPackage("com.instagram.android");
////        if (intent != null) {
////            val shareIntent =  Intent();
////            shareIntent.setAction(Intent.ACTION_SEND);
////            shareIntent.setPackage("com.instagram.android");
////            try {
////                shareIntent.putExtra(Intent.EXTRA_TEXT,"YOUR TEXT TO SHARE IN INSTAGRAM")
//////                shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("https://www.searchenginejournal.com/wp-content/uploads/2018/10/How-to-Boost-Your-Images%E2%80%99-Visibility-on-Google-Images-760x400.png"))
////            } catch ( e: FileNotFoundException) {
////                e.printStackTrace();
////            }
////            shareIntent.setType("text/plain");
////            startActivity(shareIntent);
////        } else {
////            // bring user to the market to download the app.
////            // or let them choose an app?
////            val intent =  Intent(Intent.ACTION_VIEW);
////            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////            intent.setData(Uri.parse("market://details?id=" + "com.instagram.android"));
////            startActivity(intent);
////        }
//    }



}