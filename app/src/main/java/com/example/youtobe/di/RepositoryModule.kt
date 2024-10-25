package com.example.youtobe.di

import com.example.youtobe.data.repository.YouTubeRepository
import org.koin.dsl.module

val repositoryModule = module {

    single {
        YouTubeRepository(get())
    }
}