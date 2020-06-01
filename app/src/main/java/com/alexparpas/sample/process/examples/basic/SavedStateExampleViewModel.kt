package com.alexparpas.sample.process.examples.basic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class SavedStateExampleViewModel @Inject constructor() : ViewModel() {
    private val _formLiveData = MutableLiveData<Form>()
    val formLiveData: LiveData<Form> get() = _formLiveData

    fun onSaveClicked(form: Form) {
        _formLiveData.value = form
    }
}

data class Form(
    val firstName: String,
    val lastName: String,
    val age: String,
    val gender: String,
    val address: String
)