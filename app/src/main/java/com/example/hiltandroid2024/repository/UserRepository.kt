package com.example.hiltandroid2024.repository

import javax.inject.Inject


/**
 * If we run this code then Hilt will throw a error.
 * Because hilt can't create the object of UserRepository.
 *
 * In this case we need to provide the UserRepository object to hilt.
 * Create a class and annotate with Module and provides from there
 */
interface UserRepository {
    fun saveUser(name: String, email: String)
}

class SQLRepository @Inject constructor() : UserRepository {
    override fun saveUser(name: String, email: String) {
        println("LENSA user saved in SQL")
    }
}

class FirebaseRepository: UserRepository {
    override fun saveUser(name: String, email: String) {
        println("LENSA user saved in Firebase")
    }
}