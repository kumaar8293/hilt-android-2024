package com.example.hiltandroid2024.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hiltandroid2024.annotations.FirebaseAnnotation
import com.example.hiltandroid2024.databinding.FragmentMainBinding
import com.example.hiltandroid2024.repository.LoggerService
import com.example.hiltandroid2024.repository.UserRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    @FirebaseAnnotation
    @Inject
    lateinit var userRepository: UserRepository

    /**
     * Since we are injecting UserRepository 2 times here,
     * it will create 2 different object for the UserRepository
     *
     * to fix this issue, we need to annotate our UserRepository
     * provides methods inside our UserModule with Scope
     * Depending on our requirement. i.e FragmentScope, ActivityScope etc
     *
     * Since I am using UserRepository inside fragment only then we
     * will annotate it with @FragmentScope
     *
     * Check UserModule.kt line no 46
     */
    @FirebaseAnnotation
    @Inject
    lateinit var userRepository2: UserRepository

    @Inject
    lateinit var loggerService: LoggerService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userRepository.saveUser(
            "Fragment",
            "main@fragment.com ${userRepository.hashCode()} ${userRepository2.hashCode()}"
        )

        loggerService.log("Calling from application class and object is ${loggerService.hashCode()}")
    }
}