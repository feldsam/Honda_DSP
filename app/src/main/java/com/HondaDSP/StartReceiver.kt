package com.HondaDSP

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class StartReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED && getServiceState(context) == ServiceState.STARTED) {
            Intent(context, HondaDspService::class.java).also {
                it.action = Actions.START.name
                    context.startForegroundService(it)
             }
        }
    }
}

