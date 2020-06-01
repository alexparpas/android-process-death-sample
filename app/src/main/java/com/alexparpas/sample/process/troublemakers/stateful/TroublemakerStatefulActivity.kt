package com.alexparpas.sample.process.troublemakers.stateful

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.alexparpas.sample.process.App
import com.alexparpas.sample.process.databinding.ActivityTroublemakerStatefulInstancesBinding

class TroublemakerStatefulActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTroublemakerStatefulInstancesBinding

    private val viewModel: TroublemakerStatefulViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)

        binding = ActivityTroublemakerStatefulInstancesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.createRoomButton.setOnClickListener {
            onCreateRoomClicked()
        }

        render()
    }

    @SuppressLint("SetTextI18n")
    private fun render() {
        //Room text view
        binding.gameRoomTextView.text = "Game Room: ${viewModel.gameRoomId}"

        //Playing text view
        binding.playingTextView.visibility = if (viewModel.gameRoomId == null) View.GONE else View.VISIBLE

        //Game (in progress) views
        binding.makeMoveButton.apply {
            visibility = if (viewModel.gameRoomId == null) View.GONE else View.VISIBLE
            setOnClickListener { onMakeMoveClicked() }
        }
    }

    private fun onCreateRoomClicked() {
        viewModel.createGameRoom { gameRoomId ->
            viewModel.gameRoomId = gameRoomId
            render()
        }
    }

    private fun onMakeMoveClicked() {
        viewModel.gameRoomId?.let {
            Toast.makeText(this, "Syncing room $it", Toast.LENGTH_SHORT).show()
            viewModel.syncGame(it)
        }
    }
}