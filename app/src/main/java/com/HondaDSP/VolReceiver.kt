package com.HondaDSP

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.AudioManager


class VolReceiver : BroadcastReceiver() {


    override fun onReceive(context: Context, intent: Intent) {

        val audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        val currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)
            HondaDspService.getInstance()?.updateHex("volSysValue", currentVolume)
            HondaDspService.getInstance()?.policzService()
        MainActivity.getInstance()?.updateVolume(currentVolume, "sys")

    }
}