package com.example.android.musicplayer

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    private var mediaPlayer: MediaPlayer? = null
    private var curVolume = 0.5f
    private val maxVolume = 1f
    private val minVolume = 0f

    fun play(view: View?) {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.my_music)
        }
        mediaPlayer?.start()
        mediaPlayer?.setOnCompletionListener{ mp ->
            Log.v("MusicPlayer","I'm done!")
            Toast.makeText(this@MainActivity, "I'm done", Toast.LENGTH_SHORT).show()
        }
    }

    fun pause(view: View?) {
        mediaPlayer?.pause()
    }

    fun skip(view: View?) {
        mediaPlayer?.seekTo(mediaPlayer!!.duration / 2)
    }

    fun volumeUp(view: View?) {
        if (curVolume > minVolume) curVolume += 0.1f
        mediaPlayer?.setVolume(curVolume, curVolume)
    }

    fun volumeDown(view: View?) {
        if (curVolume > minVolume) curVolume -= 0.1f
        mediaPlayer?.setVolume(curVolume, curVolume)
    }
}