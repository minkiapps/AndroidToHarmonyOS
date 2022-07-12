package com.minkiapps.shared.util

const val DEFAULT_TAG = "Logger"

interface ILogger {
    fun debug(tag: String, message: String)

    fun error(tag: String, message: String)
}

class Logger(private val iLogger: ILogger) {

    private val tag: String
        get() {
            return Throwable().stackTrace
                .firstOrNull { it.className != Logger::class.java.name }
                ?.let {
                    val className = it.className
                    val lastIndexOfDot = className.lastIndexOf(".")
                    if (lastIndexOfDot == -1) {
                        return@let DEFAULT_TAG
                    }
                    className.substring(lastIndexOfDot + 1)
                } ?: DEFAULT_TAG
        }

    fun d(msg: String) {
        iLogger.debug(tag, msg)
    }

    fun e(msg: String, throwable: Throwable) {
        iLogger.error(tag, "$msg\n$throwable")
    }
}