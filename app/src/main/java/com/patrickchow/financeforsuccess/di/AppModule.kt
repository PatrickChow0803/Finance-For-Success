package com.patrickchow.financeforsuccess.di

import com.patrickchow.financeforsuccess.data.api.RedditApiService
import com.patrickchow.financeforsuccess.data.repository.RedditStockRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://tradestie.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideRedditApiService(retrofit: Retrofit): RedditApiService {
        return retrofit.create(RedditApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRedditStockRepository(apiService: RedditApiService): RedditStockRepository {
        return RedditStockRepository(apiService)
    }
}
