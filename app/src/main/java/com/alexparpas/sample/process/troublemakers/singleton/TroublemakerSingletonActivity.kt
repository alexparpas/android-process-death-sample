package com.alexparpas.sample.process.troublemakers.singleton

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alexparpas.sample.process.databinding.ActivityTroublemakerSingletonBinding

class TroublemakerSingletonActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTroublemakerSingletonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTroublemakerSingletonBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}