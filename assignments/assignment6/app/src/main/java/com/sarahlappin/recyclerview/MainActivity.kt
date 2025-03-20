package com.sarahlappin.recyclerview

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sarahlappin.recyclerview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels() // ViewModel for lifecycle-aware data management

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize ViewBinding for activity_main.xml
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.items.observe(this) { items ->
        // Set up RecyclerView
        val adapter = RecyclerAdapter(items) // Create adapter with an initial empty list
        binding.recyclerView.layoutManager = LinearLayoutManager(this) // Set linear layout manager
        binding.recyclerView.adapter = adapter // Attach adapter to RecyclerView

        // Observe LiveData from ViewModel and update RecyclerView

          // Update RecyclerView with new data
        }
    }
}