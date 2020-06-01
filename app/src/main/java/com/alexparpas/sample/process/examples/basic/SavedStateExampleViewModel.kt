package com.alexparpas.sample.process.examples.basic

import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.android.parcel.Parcelize

class SavedStateExampleViewModel(
    private val savedState: SavedStateHandle
) : ViewModel() {
    val formLiveData: LiveData<Form> get() = savedState.getLiveData(ARG_STATE_FORM)

    fun onSaveClicked(form: Form) {
        savedState.set(ARG_STATE_FORM, form)
    }

    companion object {
        const val ARG_STATE_FORM = "ARG_STATE_FORM"
    }
}

@Parcelize
data class Form(
    val firstName: String,
    val lastName: String,
    val age: String,
    val gender: String,
    val address: String
): Parcelable