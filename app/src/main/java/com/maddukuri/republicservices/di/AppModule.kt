package com.maddukuri.republicservices.di

import android.content.Context
import androidx.room.Room
import com.maddukuri.republicservices.data.room.AppDatabase
import com.maddukuri.republicservices.data.source.local.DefaultLocalDataRepository
import com.maddukuri.republicservices.data.source.local.LocalDataRepository
import com.maddukuri.republicservices.data.source.remote.DefaultRemoteDataRepository
import com.maddukuri.republicservices.data.source.remote.RemoteDataRepository
import com.maddukuri.republicservices.network.RemoteAPI
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Dagger module to provide dependencies for the application
 */
@Module
class AppModule {

    // Provide a singleton instance of AppDatabase
    @Singleton
    @Provides
    fun provideDataBase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "app-database"
        ).build()
    }

    // Provide an implementation of LocalDataRepository
    @Provides
    fun provideLocalDataRepository(appDatabase: AppDatabase): LocalDataRepository =
        DefaultLocalDataRepository(appDatabase)

    // Provide an implementation of RemoteDataRepository
    @Provides
    fun provideDriverDataRepository(
        localDataRepository: LocalDataRepository,
        apiService: RemoteAPI
    ): RemoteDataRepository =
        DefaultRemoteDataRepository(localDataRepository, apiService)
}
