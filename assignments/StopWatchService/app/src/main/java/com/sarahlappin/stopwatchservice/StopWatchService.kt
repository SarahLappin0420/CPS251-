package com.sarahlappin.stopwatchservice
import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.SystemClock

class StopWatchService : Service() {
    private val binder = LocalBinder()
    private val handler = Handler(Looper.getMainLooper())
    private var startTime = 0L
    private var elapsedTime = 0L
    private var running = false

    private val updateRunnable = object : Runnable {
        override fun run() {
            if (running) {
                elapsedTime = SystemClock.elapsedRealtime() - startTime
                // Broadcast elapsed time to the MainActivity
                broadcastElapsedTime(elapsedTime)
                handler.postDelayed(this, 1000) // Update every second
            }
        }
    }

    inner class LocalBinder : Binder() {
        fun getService(): StopWatchService = this@StopWatchService
    }

    override fun onBind(intent: Intent?): IBinder {
        return binder
    }

    fun startStopWatch() {
        if (!running) {
            startTime = SystemClock.elapsedRealtime() - elapsedTime // Resume from paused time
            handler.post(updateRunnable)
            running = true
        }
    }

    fun pauseStopWatch() {
        if (running) {
            handler.removeCallbacks(updateRunnable)
            running = false
        }
    }

    fun resetStopWatch() {
        pauseStopWatch()
        elapsedTime = 0L
        broadcastElapsedTime(elapsedTime) // Notify MainActivity to reset UI
    }

    fun getElapsedTime(): Long {
        return elapsedTime
    }

    private fun broadcastElapsedTime(elapsedTime: Long) {
        val intent = Intent("com.sarahlappin.stopwatchservice.ELAPSED_TIME")
        intent.putExtra("elapsed_time", elapsedTime)
        sendBroadcast(intent)
    }
}
