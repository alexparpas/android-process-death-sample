package com.alexparpas.sample.process.examples.navigation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.alexparpas.sample.process.App
import com.alexparpas.sample.process.R
import com.alexparpas.sample.process.databinding.ActivityNavigationBinding
import com.alexparpas.sample.process.utils.switchFragment
import javax.inject.Inject

class NavigationExampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNavigationBinding

    private val viewModel: NavigationExampleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)

        super.onCreate(savedInstanceState)

        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigationView()

        if (savedInstanceState == null) {
            supportFragmentManager.switchFragment(R.id.fragContainer, NavigationExampleFragment1.newInstance())
        }
    }

    private fun initBottomNavigationView() {
        with(supportFragmentManager) {
            binding.bottomNavigationView.setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.menuItem1 -> switchFragment(R.id.fragContainer, NavigationExampleFragment1.newInstance())
                    R.id.menuItem2 -> switchFragment(R.id.fragContainer, NavigationExampleFragment2.newInstance())
                }
                true //true to display the item as the selected item
            }
        }
    }
}