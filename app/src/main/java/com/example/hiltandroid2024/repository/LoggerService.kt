package com.example.hiltandroid2024.repository

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton


/**
 * If I want only one object for the logger service then we need to annotate it with @Singleton
 *
 */
@Singleton
class LoggerService @Inject constructor() {
    fun log(message: String) {
        Log.d(LOGGER_TAG, message)
    }

    companion object {
        const val LOGGER_TAG = "LOGGER"
    }
}