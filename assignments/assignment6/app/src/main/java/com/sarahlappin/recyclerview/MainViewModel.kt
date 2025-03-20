package com.sarahlappin.recyclerview
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sarahlappin.recyclerview.RandomItem
class MainViewModel :ViewModel(){
    private val data = Data() // Assume Data provides titles, details, and image resources
    private val _items = MutableLiveData<List<RandomItem>>()
    val items: LiveData<List<RandomItem>> get() = _items

    init {
        generateRandomItems()
    }

    private fun generateRandomItems() {
        val randomList = List(data.titles.size) {
            RandomItem(
                title = data.titles.random(),
                detail = data.details.random(),
                imageResId = data.images.random()
            )
        }
        _items.value = randomList
    }
}
