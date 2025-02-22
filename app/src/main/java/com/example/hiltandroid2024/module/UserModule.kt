package com.example.hiltandroid2024.module

import com.example.hiltandroid2024.annotations.FirebaseAnnotation
import com.example.hiltandroid2024.annotations.SQLAnnotation
import com.example.hiltandroid2024.repository.FirebaseRepository
import com.example.hiltandroid2024.repository.SQLRepository
import com.example.hiltandroid2024.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import javax.inject.Named


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
class UserModule {
    /**
     * Since both function returns the UserRepository object the
     * dagger will be confused which function to use.
     *
     * In this case we will be using @Named annotation.
     * I have created my own annotation which uses all the properties
     * of @Named annotation to avoid Name typo issue.
     *
     * We have to tell the caller to use the same annotation to get the right object.
     */


    @SQLAnnotation
    @Provides
    fun providesSQLRepository(sqlRepository: SQLRepository): UserRepository {
        return sqlRepository
    }

    @FirebaseAnnotation
    @Provides
    fun providesFirebaseRepository(): UserRepository {
        return FirebaseRepository()
    }
}