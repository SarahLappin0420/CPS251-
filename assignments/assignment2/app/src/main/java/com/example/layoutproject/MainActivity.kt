package com.example.layoutproject

import android.content.res.Configuration
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

 //override fun onConfigurationChanged(newConfig: Configuration ) {
   //  super.onConfigurationChanged(newConfig)
   //   when(newConfig.orientation) {
   //       Configuration.ORIENTATION_LANDSCAPE -> {
   //       setContentView(R.layout.activity_main)
   //   }
     //  Configuration.ORIENTATION_PORTRAIT -> {
    //       setContentView(R.layout.activity_main)
        }
  // }
  // }}