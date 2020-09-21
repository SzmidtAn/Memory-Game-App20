package com.example.lektion2

import android.R
import android.app.Service
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.IBinder
import androidx.annotation.Nullable


class BackGroundMusic : Service() {
    var mediaPlayer: MediaPlayer? = null
    var audioManager: AudioManager? = null
    var volume = 0
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }



}