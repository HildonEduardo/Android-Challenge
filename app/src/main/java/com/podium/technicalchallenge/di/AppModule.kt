package com.podium.technicalchallenge.di

import com.podium.technicalchallenge.data.network.GraphQLService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .client(OkHttpClient.Builder().build())
            .baseUrl("https://podium-fe-challenge-2021.netlify.app/.netlify/functions/graphql")
            .addConverterFactory(JacksonConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideGraphQLService(retrofit: Retrofit): GraphQLService {
        return retrofit.create(GraphQLService::class.java)
    }

}
