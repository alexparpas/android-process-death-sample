package com.alexparpas.sample.process

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alexparpas.sample.process.databinding.ActivityMainBinding
import com.alexparpas.sample.process.examples.basic.SavedStateExampleActivity
import com.alexparpas.sample.process.examples.navigation.NavigationExampleActivity
import com.alexparpas.sample.process.examples.recycler.RecyclerViewExampleActivity
import com.alexparpas.sample.process.troublemakers.singleton.TroublemakerSingletonActivity
import com.alexparpas.sample.process.troublemakers.stateful.TroublemakerStatefulActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleActions()
    }

    private fun handleActions() {
        binding.basicExampleButton.setOnClickListener { launchActivity(SavedStateExampleActivity::class.java) }
        binding.navigationButton.setOnClickListener { launchActivity(NavigationExampleActivity::class.java) }
        binding.recyclerViewButton.setOnClickListener { launchActivity(RecyclerViewExampleActivity::class.java) }
        binding.singletonTroublemakerButton.setOnClickListener { launchActivity(TroublemakerSingletonActivity::class.java) }
        binding.stateTroublemakerButton.setOnClickListener { launchActivity(TroublemakerStatefulActivity::class.java) }
    }

    private fun <T> launchActivity(clazz: Class<T>, shouldFinish: Boolean = false) {
        val intent = Intent(this, clazz)
        startActivity(intent)

        if (shouldFinish) finish()
    }
}
