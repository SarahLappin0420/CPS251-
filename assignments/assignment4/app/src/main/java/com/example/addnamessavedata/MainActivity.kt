package com.example.addnamessavedata

import android.os.Bundle

import androidx.lifecycle.ViewModelProvider
import com.example.addnamessavedata.databinding.ActivityMainBinding
import androidx.lifecycle.Observer
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
// Observe names LiveData
        viewModel.names.observe(this, Observer { names ->
            if (names.isEmpty()) {
                binding.textView.text = "No names to display"
            } else {
                binding.textView.text = names.joinToString(separator = "\n")
            }
        })

        // Set up button click listener
        binding.addName.setOnClickListener {
            val name = binding.editTextName.text.toString().trim()
            if (name.isEmpty()) {
                binding.textView.text = "No name entered"
            } else {
                viewModel.addName(name)
                binding.editTextName.text.clear()
            }
        }
    }
}
        //binding.textView.text = viewModel.EditText()

      //  binding.addName.setOnClickListener {
       //     viewModel.addName(binding.names.text.toString(),this)
      //  }

