package com.codeinglogs.moviedetails.ui.route

import android.content.Context
import android.content.Intent

interface PersonRoute {
    fun getPersonDetailInstance(context: Context, personId : String) : Intent
}