package com.vik.contentlisting.di

import android.content.Context
import com.vik.contentlisting.presentation.MovieRepoImpl
import com.vik.contentlisting.presentation.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesContext(@ApplicationContext context: Context): Context {
        return context
    }

    @Provides
    @Singleton
    fun providesMovieRepository(context: Context) : MovieRepository {
        return MovieRepoImpl(context)
    }

}