package com.example.hiltandroid2024.module

import com.example.hiltandroid2024.repository.FirebaseRepository
import com.example.hiltandroid2024.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent


/**
 * In case of module we need to use @InstallIn
 *
 * @InstallIn annotation work in a Component hierarchy
 * Example : SingletonComponent -> ActivityRetainedComponent -> ActivityComponent -> FragmentComponent
 * It means if we use @InstallIn at FragmentComponent level then we can't use it at it's parent level like in Activity or Application
 * And if we use @InstallIn at ActivityComponent level then we can this object in fragment level but not at application level.
 */

@InstallIn(FragmentComponent::class)
@Module
class UserRepositoryModule {

    @Provides
    fun providesUserRepository(): UserRepository {
        return FirebaseRepository()
    }
}