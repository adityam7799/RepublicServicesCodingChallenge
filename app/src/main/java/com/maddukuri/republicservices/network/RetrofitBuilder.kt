package com.maddukuri.republicservices.network

import com.maddukuri.republicservices.AppConstants.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Dagger module for building the Retrofit instance and providing the RemoteAPI.
 */
@Module
class RetrofitBuilder {

    // Provide a singleton instance of RemoteAPI using Retrofit
    @Singleton
    @Provides
    fun provideRemoteAPI(): RemoteAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RemoteAPI::class.java)
    }
}
