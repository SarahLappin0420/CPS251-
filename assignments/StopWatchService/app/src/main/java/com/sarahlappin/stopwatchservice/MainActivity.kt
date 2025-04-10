package com.sarahlappin.stopwatchservice

import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.sarahlappin.stopwatchservice.StopWatchService
import com.sarahlappin.stopwatchservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var stopWatchService: StopWatchService? = null
    private var isBound = false

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as StopWatchService.LocalBinder
            stopWatchService = binder.getService()
            isBound = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            stopWatchService = null
            isBound = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Bind to the service
        val serviceIntent = Intent(this, StopWatchService::class.java)
        bindService(serviceIntent, serviceConnection, Context.BIND_AUTO_CREATE)

        // Start button functionality
        binding.startButton.setOnClickListener {
            if (isBound) {
                stopWatchService?.startStopWatch()
                Toast.makeText(this, "Stopwatch started!", Toast.LENGTH_SHORT).show()
                updateElapsedTime()
            }
        }

        // Pause button functionality
        binding.pauseButton.setOnClickListener {
            if (isBound) {
                stopWatchService?.pauseStopWatch()
                Toast.makeText(this, "Stopwatch paused!", Toast.LENGTH_SHORT).show()
            }
        }

        // Reset button functionality
        binding.resetButton.setOnClickListener {
            if (isBound) {
                stopWatchService?.resetStopWatch()
                Toast.makeText(this, "Stopwatch reset!", Toast.LENGTH_SHORT).show()
                binding.elapsedTimeTextView.text = "00:00:00"
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isBound) {
            unbindService(serviceConnection)
            isBound = false
        }
    }

    private fun updateElapsedTime() {
        binding.elapsedTimeTextView.postDelayed({
            if (isBound && stopWatchService != null) {
                val elapsedTime = stopWatchService?.getElapsedTime() ?: 0L
                val seconds = (elapsedTime / 1000) % 60
                val minutes = (elapsedTime / (1000 * 60)) % 60
                val hours = (elapsedTime / (1000 * 60 * 60))
                binding.elapsedTimeTextView.text = String.format("%02d:%02d:%02d", hours, minutes, seconds)
            }
            updateElapsedTime() // Re-run the method to refresh the UI
        }, 1000)
    }
}
