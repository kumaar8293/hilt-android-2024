package com.example.hiltandroid2024.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hiltandroid2024.annotations.FirebaseAnnotation
import com.example.hiltandroid2024.databinding.ActivitySampleBinding
import com.example.hiltandroid2024.repository.UserRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SampleActivity : AppCompatActivity() {

    /**
     * If we rotate the screen then activity will be recreated and UserRepository will be recreated.
     *
     * To avoid object recreation we will be using @ActivityRetainedComponent at module level and @ActivityRetainedScoped
     */
    @FirebaseAnnotation
    @Inject
    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userRepository.saveUser(
            "SampleActivity",
            "sampleActivity@activity.com  ${userRepository.hashCode()}"
        )
    }
}