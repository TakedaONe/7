package com.example.youtobe.di

import com.example.youtobe.ui.playlistItems.VideoViewModel
import com.example.youtobe.ui.playlists.PlaylistsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        PlaylistsViewModel(get())
    }

    viewModel {
        VideoViewModel(get())
    }
}