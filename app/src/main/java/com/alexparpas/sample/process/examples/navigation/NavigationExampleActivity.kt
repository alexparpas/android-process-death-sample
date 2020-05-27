package com.alexparpas.sample.process.examples.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alexparpas.sample.process.databinding.ActivityNavigationBinding

class NavigationExampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}