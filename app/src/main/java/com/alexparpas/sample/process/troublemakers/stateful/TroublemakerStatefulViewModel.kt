package com.alexparpas.sample.process.troublemakers.stateful

import androidx.lifecycle.ViewModel
import java.util.*

class TroublemakerStatefulViewModel : ViewModel() {

    //Simulate loading a game room with a success callback
    fun createGameRoom(callback: (String) -> Unit) {
        callback.invoke(UUID.randomUUID().toString())
    }

    //Simulate syncing a game given a room id.
    fun syncGame(gameRoomId: String) = Unit

}