package com.example.youtobe.di

import com.example.youtobe.BuildConfig
import com.example.youtobe.data.api.YouTubeApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val youtubeModule = listOf(networkModule, repositoryModule, viewModelModule)

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()


fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
    OkHttpClient.Builder().apply {
        writeTimeout(10, TimeUnit.SECONDS)
        readTimeout(10, TimeUnit.SECONDS)
        connectTimeout(10, TimeUnit.SECONDS)
        callTimeout(10, TimeUnit.SECONDS)
        addInterceptor(interceptor)
    }.build()


fun provideInterceptor(): HttpLoggingInterceptor =
    HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

fun provideCartoonApiService(retrofit: Retrofit): YouTubeApiService =
    retrofit.create(YouTubeApiService::class.java)