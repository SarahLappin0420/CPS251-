package com.sarahlappin.coroutines

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

import com.sarahlappin.coroutines.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = RecyclerAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.namesList.observe(this) { names ->
            adapter.submitList(names)
        }


        binding.addNameButton.setOnClickListener {
            val name = binding.inputName.text.toString()
            if (name.isNotBlank()) {
                viewModel.addName(name)
                binding.inputName.text.clear()
            }
        }
    }
}

// viewModel.addName(name)
   //         binding.inputName.text.clear()
   //     }

      //  viewModel.namesList.observe(this) { names ->
      //      adapter.submitList(names)
