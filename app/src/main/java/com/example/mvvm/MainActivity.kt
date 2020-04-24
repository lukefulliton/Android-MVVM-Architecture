package com.example.mvvm

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.example.mvvm.authentication.AuthAwareActivity
import com.example.mvvm.authentication.AuthenticationActivity

class MainActivity : AuthAwareActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private val drawerLayout by lazy { findViewById<DrawerLayout>(R.id.drawer_layout) }
    private val navigationController by lazy { findNavController(R.id.nav_host_fragment) }
    private val navigationView by lazy { findViewById<NavigationView>(R.id.nav_view) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        setupNavigation()
        setupLogout()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        return navigationController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.nav_gallery ->
                true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun setupNavigation() {
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_home,
                                                        R.id.nav_gallery,
                                                        R.id.nav_slideshow,
                                                        R.id.nav_to_do_list), drawerLayout)

        setupActionBarWithNavController(navigationController, appBarConfiguration)
        navigationView.setupWithNavController(navigationController)
    }

    private fun setupLogout() {
        navigationView.menu.findItem(R.id.nav_logout).setOnMenuItemClickListener {
            logout()
            true
        }
    }

    private fun logout() {
        val intent = Intent(this, AuthenticationActivity::class.java)
        intent.putExtra(AuthenticationActivity.LOGOUT, true)
        startActivity(intent)
        finish()
    }
}
