package com.alexparpas.sample.process.troublemakers.stateful

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import java.util.*

class TroublemakerStatefulViewModel(
    private val savedState: SavedStateHandle
) : ViewModel() {

    var gameRoomId: String?
        get() = savedState.get(ARG_GAME_ROOM_ID)
        set(value) = savedState.set(ARG_GAME_ROOM_ID, value)

    //Simulate loading a game room with a success callback
    fun createGameRoom(callback: (String) -> Unit) {
        callback.invoke(UUID.randomUUID().toString())
    }

    //Simulate syncing a game given a room id.
    fun syncGame(gameRoomId: String) = Unit

    companion object {
        const val ARG_GAME_ROOM_ID = "ARG_GAME_ROOM_ID"
    }
}