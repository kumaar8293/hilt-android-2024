package com.example.hiltandroid2024.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hiltandroid2024.databinding.ActivityMainBinding
import com.example.hiltandroid2024.repository.LoggerService
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


/**
 * Once Hilt is set up in your Application class and an application-level component is available,
 * Hilt can provide dependencies to other Android classes that have the @AndroidEntryPoint annotation:
 *
 * If you annotate an Android class with @AndroidEntryPoint,
 * then you also must annotate Android classes that depend on it. For example,
 * if you annotate a fragment, then you must also annotate any activities where you use that fragment.
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var loggerService: LoggerService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loggerService.log("Calling from application class and object is ${loggerService.hashCode()}")
    }
}