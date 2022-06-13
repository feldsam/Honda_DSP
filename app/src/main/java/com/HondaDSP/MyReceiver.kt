package com.HondaDSP

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.util.Log


class MyReceiver : BroadcastReceiver() {




    override fun onReceive(context: Context, intent: Intent) {

        val audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        val currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)
        try {
            MainActivity.getInstance()?.updateVolume(currentVolume, "sys")
            //EndlessService.getInstance()?.updateVol3(currentVolume)
        } catch (e: Exception) {

        }
        Log.i("vol", "Zmiana głosniosci " + currentVolume.toString())

    }
}