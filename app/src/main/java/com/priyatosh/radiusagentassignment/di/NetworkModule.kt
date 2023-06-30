package com.priyatosh.radiusagentassignment.di

import com.priyatosh.radiusagentassignment.api.FacilitiesService
import com.priyatosh.radiusagentassignment.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesFacilitiesService(retrofit: Retrofit) : FacilitiesService {
        return retrofit.create(FacilitiesService::class.java)
    }
}