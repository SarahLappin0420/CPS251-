package com.sarahlappin.coroutines
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainViewModel :ViewModel() {
    private val _namesList = MutableLiveData<List<String>>()
    val namesList: LiveData<List<String>> = _namesList

    private val names = mutableListOf<String>()

    fun addName(name: String) {
        names.add(name)
        _namesList.value = names.toList()

        viewModelScope.launch(Dispatchers.IO) {
            val sleepTime = Random.nextInt(1, 10) * 1000L
            delay(sleepTime)
            val greenBackground = "\u001B[42m"
            val resetColor = "\u001B[0m"
            val updatedName = "My name is $name and the delay was ${sleepTime}ms"
            val greenOutput = "$greenBackground$updatedName$resetColor"


            synchronized(names) {
                val index = names.indexOf(name)
                if (index != -1) {
                    names[index] = updatedName
                    _namesList.postValue(names.toList())
                    // Log or print the message
                    println(updatedName)
                }
            }
        }
    }

                }




