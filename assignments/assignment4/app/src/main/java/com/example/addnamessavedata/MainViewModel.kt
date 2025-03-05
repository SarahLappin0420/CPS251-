package com.example.addnamessavedata
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData

class MainViewModel : ViewModel() {
    private val _names = MutableLiveData<List<String>>(emptyList())
    val names: LiveData<List<String>> get() = _names

    fun addName(name: String) {
        if (name.isBlank()) return
        val updatedNames = _names.value!!.toMutableList()
        updatedNames.add(name)
        _names.value = updatedNames
    }
}