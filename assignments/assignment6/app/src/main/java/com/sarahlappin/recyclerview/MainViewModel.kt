package com.sarahlappin.recyclerview

import android.view.LayoutInflater
import android.content.Intent
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel


import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.sarahlappin.recyclerview.databinding.ActivityMainBinding // Replace with your actual package name


class MainViewModel : ViewModel() {
    companion object{
        var intlist: ArrayList<ArrayList<Int>> = arrayListOf()
    }
    fun generateArr(): ArrayList<ArrayList<Int>> {
        if (intlist.isEmpty()) {
            val num = 7
            for (i in 0..num) {
                intlist.add(arrayListOf((0..7).random(), (0..7).random(), (0..7).random()))
            }
        }



        return intlist
    }
}

