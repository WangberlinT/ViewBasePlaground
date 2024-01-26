package com.tiki.viewbaseplaground.home

import android.os.Bundle
import androidx.navigation.activity
import androidx.navigation.createGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.fragment
import com.tiki.viewbaseplaground.R
import com.tiki.viewbaseplaground.databinding.LayoutHomeScreenBinding
import com.tiki.viewbaseplaground.examples.dispatch_events.DispatchEventActivity
import com.tiki.viewbaseplaground.examples.intercept_events.ViewPager2GestureTestActivity

class HomeActivity: BaseActivity() {
    private lateinit var binding: LayoutHomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        val navController = navHostFragment.navController
        navController.graph = navController.createGraph(
            startDestination = Destinations.catalog
        ) {
            fragment<CatalogFragment>(Destinations.catalog)
            activity(Destinations.eventDispatching) {
                activityClass = DispatchEventActivity::class
            }
            activity(Destinations.viewPagerIntercept) {
                activityClass = ViewPager2GestureTestActivity::class
            }
        }
    }
}


object Destinations {
    const val catalog = "catalog"
    const val eventDispatching = "event_dispatching"
    const val viewPagerIntercept = "view_pager_intercept"
}