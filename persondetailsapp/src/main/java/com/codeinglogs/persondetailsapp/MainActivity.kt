package com.codeinglogs.persondetailsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.codeinglogs.persondetails.ui.activity.PersonDetailsActivity
import com.codeinglogs.persondetails.ui.activity.PersonPagingActivity
import com.codeinglogs.presentation.model.person.personenum.PersonType

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = findViewById<TextView>(R.id.text)
        text.setOnClickListener {
            startActivity(PersonDetailsActivity.getInstance(this,"1136406"))
        }

     //   startActivity(PersonPagingActivity.getInstance(this, PersonType.SEARCH))
    }
}