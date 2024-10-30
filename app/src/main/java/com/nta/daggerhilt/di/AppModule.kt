package com.nta.daggerhilt.di

import android.app.Application
import com.nta.daggerhilt.data.remote.MyApi
import com.nta.daggerhilt.data.repository.MyRepositoryImpl
import com.nta.daggerhilt.domain.repository.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides //this function provide a function
    @Singleton // to call same Retrofit instance from different repository when two repositories need this MyApi without creating new two instance
    fun provideMyApi(): MyApi {
        return Retrofit.Builder()
            .baseUrl("https://test.com")
            .build()
            .create(MyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(
        api: MyApi,
        app: Application,
        @Named("String1") string1: String
    ): MyRepository {
        return MyRepositoryImpl(api, app)
    }

    //Two dependencies of same type // Used @Named to tell dagger which one to use
    @Provides
    @Singleton
    @Named("String1")
    fun provideString1() = "String 1"

    @Provides
    @Singleton
    @Named("String1")
    fun provideString2() = "String 2"


}