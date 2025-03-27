package com.sarahlappin.recyclerview
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sarahlappin.recyclerview.databinding.ActivitySecondBinding
import android.content.Intent

class SecondActivity: AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Retrieve data passed via intent
        val title = intent.getStringExtra("title")
        val detail = intent.getStringExtra("detail")
        val imageResId = intent.getIntExtra("imageResId", -1)
        val arrayIndex = intent.getIntExtra("arrayIndex", -1)
        // Display the data in UI
        binding.itemTitle.text = title
        binding.itemDetail.text = detail
        binding.itemImage.setImageResource(imageResId)


    }
}
