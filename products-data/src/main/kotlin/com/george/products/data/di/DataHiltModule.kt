package com.george.products.data.di

import com.george.products.data.RepositoryImpl
import com.george.products.data.datasource.RemoteDS
import com.george.products.data.datasource.RemoteDSImpl
import com.george.products.data.service.ApiService
import com.george.products.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module(includes = [DataModule::class])
internal class DataApiModule {

    @Singleton
    @Provides
    fun provideApiService(): ApiService = ApiService()

}

@InstallIn(SingletonComponent::class)
@Module
internal interface DataModule {

    @Singleton
    @Binds
    fun bindRemoteDataSource(remoteDSImpl: RemoteDSImpl): RemoteDS

    @Singleton
    @Binds
    fun bindRepository(repositoryImpl: RepositoryImpl): Repository
}