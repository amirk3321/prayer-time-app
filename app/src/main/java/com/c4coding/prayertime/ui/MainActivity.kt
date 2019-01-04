package com.c4coding.prayertime.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import com.c4coding.prayertime.R
import kotlinx.android.synthetic.main.activity_main.*
//Target
//Services background  and brodCast Receivers
//Notification -> timerApp();
class MainActivity : AppCompatActivity() {
    lateinit var mNavController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        mNavController=Navigation.findNavController(this,R.id.host_nav)

        NavigationUI.setupWithNavController(bottom_nav,mNavController)
        NavigationUI.setupActionBarWithNavController(this,mNavController)

    }

    override fun onSupportNavigateUp()= NavigationUI.navigateUp(mNavController,null)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.setting,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return item!!.onNavDestinationSelected(mNavController) || super.onOptionsItemSelected(item)
    }

}
