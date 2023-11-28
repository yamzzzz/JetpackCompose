package com.yami.app.navigationdemo.di

import com.yami.app.navigationdemo.data.repository.PostRepositoryImpl
import com.yami.app.navigationdemo.domain.repository.PostRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RemoteModule {

    @Binds
    abstract fun provideRepository(impl: PostRepositoryImpl) : PostRepository
}
