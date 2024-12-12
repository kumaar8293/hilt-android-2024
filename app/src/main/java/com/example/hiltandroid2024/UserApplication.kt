package com.example.hiltandroid2024

import android.app.Application
import com.example.hiltandroid2024.repository.LoggerService
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

/**
 * @HiltAndroidApp triggers Hilt's code generation, including a base class for your application
 * that can use dependency injection. The application container is the parent container for the app,
 * which means that other containers can access the dependencies that it provides.
 */
@HiltAndroidApp
class UserApplication : Application(){
    @Inject
    lateinit var loggerService: LoggerService
    override fun onCreate() {
        super.onCreate()
        loggerService.log("Calling from application class and object is ${loggerService.hashCode()}")
    }
}


