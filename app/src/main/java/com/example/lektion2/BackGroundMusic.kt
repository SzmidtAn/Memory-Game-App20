package com.example.lektion2

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder


    var mediaPlayerBackgrundMusic: MediaPlayer? = null
class BackGroundMusic : Service() {
    override fun onBind(intent: Intent): IBinder? {
        return null
    }


    override fun onCreate() {
        super.onCreate();
        mediaPlayerBackgrundMusic = MediaPlayer.create(this, com.example.lektion2.R.raw.home);
        mediaPlayerBackgrundMusic?.isLooping=true



    }





    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        mediaPlayerBackgrundMusic!!.start()
        return startId
    }

    override fun onStart(intent: Intent, startId: Int) {}
    override fun onDestroy() {
        mediaPlayerBackgrundMusic!!.pause()
        mediaPlayerBackgrundMusic!!.release()
    }

    override fun onLowMemory() {}
}