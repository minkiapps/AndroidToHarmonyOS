package com.minkiapps.android.example.util

import android.util.Log
import com.minkiapps.shared.util.ILogger

class LoggerFacade : ILogger {

    override fun debug(tag: String, message: String) {
        Log.d(tag, message)
    }

    override fun error(tag: String, message: String) {
        Log.d(tag, message)
    }
}