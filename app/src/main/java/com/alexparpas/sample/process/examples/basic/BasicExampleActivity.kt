package com.alexparpas.sample.process.examples.basic

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.alexparpas.sample.process.databinding.ActivityBasicExampleBinding

class BasicExampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBasicExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBasicExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}