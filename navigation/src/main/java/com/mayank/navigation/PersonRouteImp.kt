package com.mayank.navigation

import android.content.Context
import android.content.Intent
import com.codeinglogs.moviedetails.ui.route.PersonRoute
import com.codeinglogs.persondetails.ui.activity.PersonDetailsActivity
import javax.inject.Inject

class PersonRouteImp @Inject constructor (): PersonRoute {
    override fun getPersonDetailInstance(context: Context, personId: String) = Intent(context, PersonDetailsActivity::class.java)
    .apply {
        putExtra(PersonDetailsActivity.PERSON_ID,personId)
    }
}