package com.codeinglogs.persondetails.ui.activity

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.codeinglogs.core.base.BaseActivity
import com.codeinglogs.persondetails.R
import com.codeinglogs.persondetails.databinding.ActivityPersonPagingBinding
import com.codeinglogs.persondetails.ui.fragmet.PersonPagingFragmentArgs
import com.codeinglogs.presentation.model.person.personenum.PersonType
import com.codeinglogs.presentation.viewmodel.pagingperson.PersonPagingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonPagingActivity  : BaseActivity<PersonPagingViewModel, ActivityPersonPagingBinding>() {

    private lateinit var navController: NavController

    override val mViewModel: PersonPagingViewModel by viewModels()
    override fun getViewBinding() = ActivityPersonPagingBinding.inflate(layoutInflater)

    override fun onBinding() {
        init()
    }

    private fun init(){
        val type = intent.getSerializableExtra(TYPE) as PersonType
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController=navHostFragment.navController
        navController.setGraph(R.navigation.person_nav_graph,PersonPagingFragmentArgs(type).toBundle())
    }

    companion object{
        const val TYPE = "type"
        fun getInstance(context: Context, type : PersonType) = Intent(context, PersonPagingActivity::class.java).apply {
            putExtra(TYPE,type)
        }
    }


}
