package com.alexparpas.sample.process.troublemakers.stateful

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alexparpas.sample.process.databinding.ActivityTroublemakerStatefulInstancesBinding

class TroublemakerStatefulActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTroublemakerStatefulInstancesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTroublemakerStatefulInstancesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}