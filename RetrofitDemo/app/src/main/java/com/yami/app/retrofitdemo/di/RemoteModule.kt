package com.yami.app.retrofitdemo.di

import com.yami.app.retrofitdemo.data.repository.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named

@InstallIn(SingletonComponent::class)
@Module
class RemoteModule {

    @Provides
    fun provideAPI(@Named("retrofit") retrofit: Retrofit): APIService = retrofit.create(APIService::class.java)
}