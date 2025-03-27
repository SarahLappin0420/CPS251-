package com.sarahlappin.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sarahlappin.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // Sample data
    private val titles = listOf("Title 1", "Title 2", "Title 3","Title 4","Title5",
        "Title 6", "Title 7")
    private val details = listOf("Detail 1", "Detail 2", "Detail 3", "Detail 4", "Detail 5", "Detail 6", "Detail 7")
    private val images = listOf(R.mipmap.image1, R.mipmap.image2, R.mipmap.image3,R.mipmap.image4,R.mipmap.image5, R.mipmap.image6, R.mipmap.image7)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    MainViewModel().generateArr()
        // Generate random items
        val titles = listOf("Title 1", "Title 2", "Title 3", "Title 4","Title5",
            "Title 6", "Title 7")
        val details = listOf("Detail 1", "Detail 2", "Detail 3","Detail 4", "Detail 5", "Detail 6", "Detail 7")
        val images = listOf(R.mipmap.image1, R.mipmap.image2, R.mipmap.image3,R.mipmap.image4,R.mipmap.image5, R.mipmap.image6, R.mipmap.image7)

        val randomItems = MainViewModel.intlist.map { index ->
            RandomItem(
                title = titles[index[0] % titles.size],
                detail = details[index[1] % details.size],
                imageResId = images[index[2] % images.size]
            )
        }




        // Set up RecyclerView
        val adapter = RecyclerAdapter(randomItems)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }
}