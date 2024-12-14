package com.example.hiltandroid2024.repository

import javax.inject.Inject


interface UserRepository {
    fun saveUser(name: String, email: String)
}

class SQLRepository @Inject constructor() : UserRepository {
    override fun saveUser(name: String, email: String) {
        println("LENSA user saved in SQL $name and $email")
    }
}

class FirebaseRepository: UserRepository {
    override fun saveUser(name: String, email: String) {
        println("LENSA user saved in Firebase $name and $email")
    }
}