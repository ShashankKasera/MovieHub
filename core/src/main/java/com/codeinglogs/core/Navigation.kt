package com.codeinglogs.core

import android.content.Context
import android.content.Intent

object Navigation {
    object PersonDetail{
        const val PERSON_ID = "PersonId"
        fun getPersonDetailInstance(context: Context, personId : String) = Intent(Intent.ACTION_VIEW)
            .apply {
                setClassName("com.codeinglogs.persondetails", "com.codeinglogs.persondetails.ui.activity.PersonDetailsActivity")
                putExtra(PERSON_ID,personId)
            }
    }


}