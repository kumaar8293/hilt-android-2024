package com.example.hiltandroid2024.repository

import javax.inject.Inject


class UserRepository @Inject constructor() {

    fun saveUser(name: String, email: String) {
        println("LENSA user saved $name $email")
    }
}